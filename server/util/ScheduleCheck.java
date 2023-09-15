package ua.tntu.server.util;

import ua.tntu.server.dao.EmployeeDAO;
import ua.tntu.server.dao.EntryDAO;
import ua.tntu.server.dao.WorkDayDAO;
import ua.tntu.server.model.Employee;
import ua.tntu.server.model.Entry;
import ua.tntu.server.model.WorkDay;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.TimerTask;

public class ScheduleCheck extends TimerTask {
    public void run() {
        WorkDayDAO workDayDAO = new WorkDayDAO();
        EntryDAO entryDAO = new EntryDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        for(Employee employee : employeeDAO.getAllEmployee()){
            if(employee.getEmployeeStatus().equals("Active")){
                List<Entry> entryList = entryDAO
                        .getAllEntryByDay(employee.getEmployeeId(), LocalDate.now());
                if(entryList.size() == 0){
                    workDayDAO.addWorkDay(new WorkDay(employee, LocalDate.now(), "Absent"));
                } else if (entryList.get(0)
                        .getEntryTime()
                        .toLocalTime()
                        .isAfter(employee.getStartTime())){
                    workDayDAO.addWorkDay(new WorkDay(employee, LocalDate.now(), "Late"));
                } else {
                    workDayDAO.addWorkDay(new WorkDay(employee, LocalDate.now(), "In time"));
                }
            }
        }
    }
}
