package cms.spring.mvc.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cms.spring.mvc.entities.Member;

@Repository
public class MemberRepository {
	@Autowired
	SessionFactory sf;

	public Member findOne(String email) {
		Session session = sf.openSession();
		Member result = null;

		try {
			String strHql = "FROM Member where email =:email";

			Query<Member> hql = session.createQuery(strHql, Member.class);
			hql.setParameter("email", email);
			List<Member> lst = hql.getResultList();
			if (lst.isEmpty()) {
				result = null;
			} else {
				result = lst.get(0);
			}
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public Member findOneByUserName(String userName) {
		Session session = sf.openSession();
		Member result = null;

		try {
			String strHql = "FROM Member where userName =:userName";

			Query<Member> hql = session.createQuery(strHql, Member.class);
			hql.setParameter("userName", userName);
			List<Member> lst = hql.getResultList();
			if (lst.isEmpty()) {
				result = null;
			} else {
				result = lst.get(0);
			}
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}


	public void saveMember(Member user) {
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			if (user != null) {
				session.save(user);
				tx.commit();
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updateMember(Member member) {
		
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			
			Member memDB = session.get(Member.class, member.getId());
			memDB.setFirstName(member.getFirstName());
			memDB.setLastName(member.getLastName());
			memDB.setPhone(member.getPhone());
			memDB.setDescription(member.getDescription());
			memDB.setUpdateTime(member.getUpdateTime());
			
			session.update(memDB);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
