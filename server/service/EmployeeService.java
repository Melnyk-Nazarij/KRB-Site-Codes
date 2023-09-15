package ua.tntu.server.service;

import ua.tntu.server.dao.EmployeeDAO;
import ua.tntu.server.model.Employee;

import java.util.List;

public class EmployeeService {
    EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void addEmployee(Employee employee){
        employeeDAO.addEmployee(employee);
    }

    public void updateEmployee(Employee employee){
        employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(int id){
        employeeDAO.deleteEmployee(id);
    }

    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }
    public Employee getEmployeeByCode(String code) {
        return employeeDAO.getEmployeeByCode(code);
    }
    public List<Employee> getAllEmployee() {
        return employeeDAO.getAllEmployee();
    }
}
