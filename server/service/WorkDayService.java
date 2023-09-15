package ua.tntu.server.service;

import ua.tntu.server.dao.WorkDayDAO;
import ua.tntu.server.model.WorkDay;

import java.util.List;

public class WorkDayService {
    WorkDayDAO workDayDAO;

    public WorkDayService(WorkDayDAO workDayDAO) {
        this.workDayDAO = workDayDAO;
    }

    public void addEntry(WorkDay employee){
        workDayDAO.addWorkDay(employee);
    }

    public void updateEntry(WorkDay employee){
        workDayDAO.updateWorkDay(employee);
    }

    public void deleteEntry(int id){
        workDayDAO.deleteWorkDay(id);
    }

    public WorkDay getEntry(int id) {
        return workDayDAO.getWorkDay(id);
    }

    public List<WorkDay> getAllEntry() {
        return workDayDAO.getAllWorkDay();
    }

    public List<WorkDay> getAllEntryByEmployee(int id) {
        return workDayDAO.getAllWorkDayByEmployee(id);
    }
}
