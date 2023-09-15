package ua.tntu.server.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.tntu.server.model.Entry;
import ua.tntu.server.util.HibernateUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class EntryDAO {
    public void addEntry(Entry entry){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(entry);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateEntry(Entry entry){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(entry);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteEntry(int id){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            Entry entry = session.get(Entry.class, id);
            if (entry != null) {
                session.delete(entry);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Entry getEntry(int id) {
        Transaction transaction = null;
        Entry entry = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            entry = session.get(Entry.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return entry;
    }

    @SuppressWarnings("unchecked")
    public List<Entry> getAllEntry() {
        Transaction transaction = null;
        List <Entry> listOfEntry = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            listOfEntry = session.createQuery("from Entry ").getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfEntry;
    }

    @SuppressWarnings("unchecked")
    public List<Entry> getAllEntryByEmployee(int employeeId) {
        Transaction transaction = null;
        List <Entry> listOfEntry = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            listOfEntry = session.createQuery("from Entry where employee = " + employeeId).getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfEntry;
    }

    public List<Entry> getAllEntryByDay(int id, LocalDate date) {
        Transaction transaction = null;
        List <Entry> listOfEntry = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            listOfEntry = session.createQuery("from Entry where employee = :id AND DATE(entryTime) = :date")
                    .setParameter("id", id)
                    .setParameter("date", Date.valueOf(date))
                    .getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfEntry;
    }
}
