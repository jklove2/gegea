package com.icss.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.icss.ssh.dao.IUserDao;
import com.icss.ssh.entity.User;

public class UserDao implements IUserDao {

	private SessionFactory sessionFactory;

	@Override
	public int add(User user) throws Exception {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int i = 0;
		i = (int) session.save(user);
		transaction.commit();
		session.close();
		return i;
	}

	@Override
	public List<User> findAll() throws Exception {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> list = null;
		list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

	@Override
	public User findById(int id) throws Exception {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class, id);
		transaction.commit();
		session.close();
		return user;
	}

	@Override
	public void update(User user) throws Exception {

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
