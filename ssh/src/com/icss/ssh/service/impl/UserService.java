package com.icss.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.icss.ssh.dao.IUserDao;
import com.icss.ssh.dao.impl.UserDao;
import com.icss.ssh.entity.User;
import com.icss.ssh.service.IUserService;

/**
 * service接口的实现类
 * 
 * @author Administrator
 *
 */
@Service
public class UserService implements IUserService {
	@Resource
	private IUserDao userDao = new UserDao();

	@Override
	public int add(User user) throws Exception {

		return userDao.add(user);

	}

	@Override
	public List<User> findAll() throws Exception {
		return userDao.findAll();
	}

	@Override
	public User findById(int id) throws Exception {
		return userDao.findById(id);

	}
	@Override
	public void update(User user) throws Exception {
		userDao.update(user);
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
