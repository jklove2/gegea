package com.icss.ssh.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.ssh.dao.IUserDao;
import com.icss.ssh.entity.User;

public class Test1 {

	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-public.xml");

	@Test
	public void testAdd() {

		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Integer save = (Integer) session.save(new User(1, "lily", "123", 12));
		System.out.println(save);
		transaction.commit();
		session.close();

	}

	@Test
	public void testFindALL() {

		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		System.out.println(list);
		transaction.commit();
		session.close();
	}

	@Test
	public void textFindById() throws Exception {
		IUserDao userDao = (IUserDao) ac.getBean("userDao");
		User user = userDao.findById(2);
		System.out.println(user);
	}

}
