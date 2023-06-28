package dao;

import model.Employee;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtils;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void save(Employee employee) {
        try ( Session session= HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee findById(int id) {
        try(Session session= HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public void update(Employee employee) {
        try (Session session= HibernateSessionFactoryUtils.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try(Session session= HibernateSessionFactoryUtils.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Query query=session.createNativeQuery("DELETE FROM employee WHERE id = :id");
            query.setParameter("id",id);
            query.executeUpdate();
            transaction.commit();
        }
    }
    @Override
    public List<Employee> findAll() {
        try(Session session= HibernateSessionFactoryUtils.getSessionFactory().openSession()){
            return session.createQuery("FROM Employee").list();
        }
    }
}
