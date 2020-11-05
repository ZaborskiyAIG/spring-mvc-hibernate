package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
      entityManager.flush();
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query =  entityManager.createQuery("from User", User.class);
      return query.getResultList();
   }

   @Override
   public void remove(Long id) {
      Query query = entityManager.createQuery("delete from User user where user.id = :id");
      query.setParameter("id", id);
      query.executeUpdate();
   }

   @Override
   public void update(User user) {
      entityManager.merge(user);
   }

   @Override
   public User getUserById(Long id) {
      return entityManager.find(User.class, id);
   }



}
