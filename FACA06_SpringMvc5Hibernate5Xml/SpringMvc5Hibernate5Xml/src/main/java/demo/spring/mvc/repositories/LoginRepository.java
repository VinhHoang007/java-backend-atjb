package demo.spring.mvc.repositories;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.spring.mvc.entities.UserEntity;

@Repository
@Transactional()
public class LoginRepository {

    @Autowired
    SessionFactory sf;

    public boolean checkLoginAdmin(String username, String password) {
        // Logic Here
        Session session = sf.openSession();
//        session.beginTransaction();

        String hql = "from User u where u.username = :username and u.password = :password and isAdmin = true";
        Query<UserEntity> query = session.createQuery(hql, UserEntity.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        UserEntity user = query.getSingleResult();
        
//        session.getTransaction().commit();

        return user != null;
    }

    public boolean checkLoginUser(String username, String password) {
        // Logic Here
        Session session = sf.openSession();
//        session.beginTransaction();
        
        String hql = "from User u where u.username = :username and u.password = :password and isAdmin = false";
        Query<UserEntity> query = session.createQuery(hql, UserEntity.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        UserEntity user = query.getSingleResult();

//        session.getTransaction().commit();
        
        return user != null;
    }
}
