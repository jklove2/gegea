package a.service;

import a.dao.UserDao;

public class UserService {

	private UserDao dao;

	public void save() {
		dao.add();
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	
}
