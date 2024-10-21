package com.SecondApp.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SecondApp.model.User;

@Repository
public class userDAOImpl implements userDAO{

	@Autowired
	SessionFactory sessionfactory;
	@Override
	public User registerUser(User user) {
		
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		session.persist(user);
		tx.commit();
		System.out.println("im in dao");
		return user;
	}
	@Override
	public List<User> getAll() {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("From User u");
		List<User> list=query.getResultList();
		Iterator it=list.iterator();
		
		while(it.hasNext()) {
			User users=(User)it.next();
			System.out.println(users);
		}
		return list;
	}
	@Override
	public String deleteUser(long userId) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		User user=session.get(User.class, userId);
		session.remove(user);
		tx.commit();
		System.out.println("im in userdaoimpl");
		return "user deleted successfully";
	}

}
