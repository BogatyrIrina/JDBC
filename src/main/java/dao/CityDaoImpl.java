package dao;

import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtils;

import java.util.List;

public class CityDaoImpl implements CityDao {

    @Override
    public void save(City city) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City findByIdCity(int id) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            return session.get(City.class, id);
        }
    }

    @Override
    public void updateCity(City city) {
        City update;
        try (Session session= HibernateSessionFactoryUtils.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }
    @Override
    public void deleteById(int id) {
        try(Session session= HibernateSessionFactoryUtils.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Query query=session.createNativeQuery("DELETE FROM city WHERE id = :id");
            query.setParameter("id",id);
            query.executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public List<City> findAllCity() {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM City").list();
        }
    }
}
