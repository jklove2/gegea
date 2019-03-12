package a.jj;

import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class User implements Serializable {

	private Integer id;
	private String name;
	private String password;

	public User() {
		super();
	}

	public User(Integer id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public void init() {
		System.out.println("user中的init方法");
	}
	
	public void destroy() {
		System.out.println("user中的destroy方法");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
