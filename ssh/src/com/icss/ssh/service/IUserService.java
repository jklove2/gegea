package com.icss.ssh.service;

import java.util.List;

import com.icss.ssh.entity.User;

/**
 * user的service接口
 * 
 * @author Administrator
 *
 */
public interface IUserService {
	/**
	 * 添加信息
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
	 * @throws Exception
	 */
	List<User> findAll() throws Exception;

	/**
	 * 通过id查询信息
	 * 
	 * @param id
	 */

	User findById(int id) throws Exception;
    /**
     * 修改信息
     * @param user
     */
	void update(User user) throws Exception;

}
