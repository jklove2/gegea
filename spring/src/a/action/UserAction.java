package a.action;

import a.service.UserService;

/**
 * 动作类
 * 
 * @author Administrator
 *
 */
public class UserAction {

	private UserService service;

	public String execute() {
		service.save();

		return "success";
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	

}
