package ua.tntu.server.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.tntu.server.model.WorkDay;
import ua.tntu.server.util.HibernateUtil;

import java.util.List;

public class WorkDayDAO {
    public void addWorkDay(WorkDay workDay){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(workDay);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateWorkDay(WorkDay workDay){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(workDay);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteWorkDay(int id){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            WorkDay workDay = session.get(WorkDay.class, id);
            if (workDay != null) {
                session.delete(workDay);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public WorkDay getWorkDay(int id) {
        Transaction transaction = null;
        WorkDay workDay = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            workDay = session.get(WorkDay.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return workDay;
    }

    @SuppressWarnings("unchecked")
    public List<WorkDay> getAllWorkDay() {
        Transaction transaction = null;
        List <WorkDay> listOfWorkDay = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            listOfWorkDay = session.createQuery("from WorkDay ").getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfWorkDay;
    }

    @SuppressWarnings("unchecked")
    public List<WorkDay> getAllWorkDayByEmployee(int employeeId) {
        Transaction transaction = null;
        List <WorkDay> listOfWorkDay = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            listOfWorkDay = session.createQuery("from WorkDay where employee = "+employeeId).getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfWorkDay;
    }
}
