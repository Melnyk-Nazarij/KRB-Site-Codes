package ua.tntu.server.controller;

import ua.tntu.server.dao.EmployeeDAO;
import ua.tntu.server.dao.EntryDAO;
import ua.tntu.server.dao.UserDAO;
import ua.tntu.server.dao.WorkDayDAO;
import ua.tntu.server.model.Employee;
import ua.tntu.server.model.Entry;
import ua.tntu.server.model.User;
import ua.tntu.server.service.EmployeeService;
import ua.tntu.server.service.EntryService;
import ua.tntu.server.service.UserService;
import ua.tntu.server.service.WorkDayService;
import ua.tntu.server.util.ScheduleCheck;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class WebController extends HttpServlet {
    private Timer timer;
    private String commandTemplate="webController?command=";

    public void init() {
        timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date timeToRun = calendar.getTime();
        timer.schedule(new ScheduleCheck(), timeToRun, 86400000);

//        (new UserService(new UserDAO())).addUser(new User("Admin","admin@gmail.com","admin","Admin"));
//        (new EmployeeService(new EmployeeDAO()))
//                .addEmployee(new Employee("Bob","CEO","Active",
//                        LocalTime.of(9,0,0),
//                        LocalTime.of(18,0,0),"123321123321"));
//        (new EmployeeService(new EmployeeDAO()))
//                .addEmployee(new Employee("Robert","CEO","Late",
//                        LocalTime.of(9,0,0),
//                        LocalTime.of(18,0,0),"123321123322"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(process(req)).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect(process(req));
    }

    private String process(HttpServletRequest request) {
        EmployeeService employeeService = new EmployeeService(new EmployeeDAO());
        EntryService entryService = new EntryService(new EntryDAO());
        UserService userService = new UserService(new UserDAO());
        WorkDayService workDayService = new WorkDayService(new WorkDayDAO());

        String commandName = request.getParameter("command");
        if(commandName == null){
            return "logIn.jsp";
        }

        if(commandName.equals("espData")){
            String code = request.getParameter("uid");
            Employee employee = employeeService.getEmployeeByCode(code);
            employee.setEmployeeStatus(employee.getEmployeeStatus().equals("Active") ? "Absent" : "Active");
            entryService.addEntry(new Entry(
                    employee,
                    LocalDateTime.now(),
                    employee.getEmployeeStatus()
            ));
        }

        if(commandName.equals("logIn")){
            String login = request.getParameter("email");
            String password = request.getParameter("password");

            User user = userService.getUserByLogin(login);
            if(user != null && user.getUserPassword().equals(password)){
                request.getSession().setAttribute("user", user);
                return commandTemplate+"main";
            }
        }

        if(commandName.equals("logOut")){
            request.getSession().invalidate();
            return "logIn.jsp";
        }

        if(commandName.equals("main")){
            if(request.getSession().getAttribute("user") != null &&
                    ((User)(request.getSession().getAttribute("user"))).getUserRole().equals("Admin")){

                request.setAttribute("employees", employeeService.getAllEmployee());

                return "main.jsp";
            }else if(request.getSession().getAttribute("user") != null &&
                    ((User)(request.getSession().getAttribute("user"))).getUserRole().equals("User")){
                return commandTemplate + "employeeInfo" + "&id="
                        + ((User)request.getSession().getAttribute("user")).getEmployee().getEmployeeId();
            }else {
                return "logIn.jsp";
            }
        }

        if(commandName.equals("employeeInfo")){
            int employeeId = Integer.parseInt(request.getParameter("id"));

            request.setAttribute("employee", employeeService
                    .getEmployee(employeeId));
            request.setAttribute("entries", entryService
                    .getAllEntryByEmployee(employeeId));
            request.setAttribute("workDays", workDayService
                    .getAllEntryByEmployee(employeeId));

            return "employeeInfo.jsp";
        }

        if(commandName.equals("accountInfo")){
            return "accountInfo.jsp";
        }

        if(commandName.equals("signUp")){
            if(request.getMethod().equals("GET")){
                return "signUp.jsp";
            }else {
                String userEmail = request.getParameter("email");
                String userPassword = request.getParameter("password");
                String userName = request.getParameter("name");
                String position = request.getParameter("position");
                String code = request.getParameter("code");
                String role = request.getParameter("role");
                LocalTime startTime = LocalTime.parse(request.getParameter("startTime"));
                LocalTime endTime = LocalTime.parse(request.getParameter("endTime"));

                Employee employee = new Employee(userName, position, "Active", startTime, endTime, code);
                User user = new User(userName, userEmail, userPassword, role);
                employee.setUser(user);
                user.setEmployee(employee);

                userService.addUser(user);

                return "logIn.jsp";
            }
        }

        return "logIn.jsp";
    }
}
