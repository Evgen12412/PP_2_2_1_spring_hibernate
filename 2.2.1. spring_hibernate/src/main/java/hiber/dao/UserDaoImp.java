package hiber.dao;


import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }
   
   @Override
   public User getUserCar(String model, int series) {
      String HQL = "FROM User u where  u.car.model=:Model and u.car.series=:Series";
      User result;

      try (Session session = sessionFactory.openSession();) {
         result = session.createQuery(HQL, User.class)
                 .setParameter("Model", model).setParameter("Series", series).getSingleResult();
      }
      return result;
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
