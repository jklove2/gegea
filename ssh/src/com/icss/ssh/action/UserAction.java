package com.icss.ssh.action;

import java.util.List;
import java.util.Map;

import com.icss.ssh.entity.User;
import com.icss.ssh.service.IUserService;
import com.icss.ssh.service.impl.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * user的动作类
 */
@SuppressWarnings("serial")

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();

	private IUserService userService = new UserService();

	@Override
	public User getModel() {

		return user;
	}

	public String user_update() throws Exception {
		userService.update(user);
		return SUCCESS;
	}

	/**
	 * 通过id查询信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String user_findById() throws Exception {
		int id = user.getId();
		userService.findById(id);
		return INPUT;
	}

	/**
	 * 添加信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		System.out.println("action");
		System.out.println(user);
		int i = userService.add(user);

		if (i > 0) {
			return SUCCESS;
		}
		return NONE;
	}

	/**
	 * 查询所有信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findAll() throws Exception {
		List<User> list = userService.findAll();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> contextMap = context.getContextMap();
		contextMap.put("list", list);
		return "list";
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
