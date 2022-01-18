package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;


    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public User getUserAndCar(String model, int series) {
//        TypedQuery<User> query = sessionFactory.getCurrentSession()
//                .createQuery("from User where id = (select id from Car where model = :model and :series)");
//        query.setParameter("model", model).setParameter("series", series);
//        return query.setMaxResults(1).getSingleResult();
        return null;
    }
}
