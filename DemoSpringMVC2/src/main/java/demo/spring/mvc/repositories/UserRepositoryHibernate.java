package demo.spring.mvc.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.spring.mvc.entities.UserEntity;
//@Repository
public class UserRepositoryHibernate {
	
	@Autowired
	SessionFactory sf;
	
	public List<UserEntity> findAll(){
		Session session = sf.openSession();
		String strHql = "FROM User";

		Query<UserEntity> hql= session.createQuery(strHql,UserEntity.class);
		
		List<UserEntity> result = hql.getResultList();
		
		return result;
	}
	
	public UserEntity findById(int userId) {
		Session session = sf.openSession();
		UserEntity result = session.get(UserEntity.class,userId );
		
		return result;
	}
}
