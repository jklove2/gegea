package com.icss.ssh.dao;

import java.util.List;

import com.icss.ssh.entity.User;

/**
 * user的dao接口
 * 
 * @author Administrator
 *
 */
public interface IUserDao {
	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int add(User user) throws Exception;

	/**
	 * 查询所有信息
	 * 
	 * @return
	 */
	List<User> findAll() throws Exception;

	/**
	 * 通过id 查询信息
	 * 
	 * @param id
	 * @return
	 */
	User findById(int id) throws Exception;

	/**
	 * 修改信息
	 * @param user
	 * @throws Exception
	 */
	void update(User user) throws Exception;

}
