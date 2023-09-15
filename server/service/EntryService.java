package ua.tntu.server.service;

import ua.tntu.server.dao.EntryDAO;
import ua.tntu.server.model.Entry;

import java.time.LocalDate;
import java.util.List;

public class EntryService {
    EntryDAO entryDAO;

    public EntryService(EntryDAO entryDAO) {
        this.entryDAO = entryDAO;
    }

    public void addEntry(Entry employee){
        entryDAO.addEntry(employee);
    }

    public void updateEntry(Entry employee){
        entryDAO.updateEntry(employee);
    }

    public void deleteEntry(int id){
        entryDAO.deleteEntry(id);
    }

    public Entry getEntry(int id) {
        return entryDAO.getEntry(id);
    }

    public List<Entry> getAllEntry() {
        return entryDAO.getAllEntry();
    }

    public List<Entry> getAllEntryByEmployee(int id) {
        return entryDAO.getAllEntryByEmployee(id);
    }

    public List<Entry> getAllEntryByDate(int id, LocalDate date){
        return entryDAO.getAllEntryByDay(id, date);
    }
}
