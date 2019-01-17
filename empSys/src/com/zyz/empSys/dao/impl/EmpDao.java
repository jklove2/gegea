package com.zyz.empSys.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.xml.internal.bind.v2.model.runtime.RuntimeNonElementRef;
import com.zyz.empSys.dao.IEmpDao;
import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.utils.MyUtils;

/**
 * empDao接口的实现类
 * 
 * @author Administrator
 *
 */
public class EmpDao implements IEmpDao {
	public QueryRunner runner = null;

	@Override
	public Emp FindEmpByNameAndPassword(String name, String password) {
		runner = MyUtils.getrunner();
		try {
			return runner.query("select * from emp where name=? and password =?", new BeanHandler<Emp>(Emp.class), name,
					password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Emp> findALL() {
		runner = MyUtils.getrunner();

		List<Emp> list = null;
		try {
			list = runner.query("select * from emp ", new BeanListHandler<Emp>(Emp.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void addEmp(Emp emp) {
		runner = MyUtils.getrunner();
		String name = emp.getName();
		String password = emp.getPassword();
		String gender = emp.getGender();
		Integer age = emp.getAge();
		Date hiredate = emp.getHiredate();
		Double salary = emp.getSalary();
		String phone = emp.getPhone();
		String email = emp.getEmail();
		try {
			runner.update("insert into emp values(null,?,?,?,?,?,?,?,?)", name, password, gender, age, hiredate, salary,
					phone, email);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmpByName(String name) {
		runner = MyUtils.getrunner();
		try {
			runner.update("delete from emp where name=?", name);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Emp FindEmpByName(String name) {
		runner = MyUtils.getrunner();
		Emp emp = null;
		try {
			emp = runner.query("select * from emp where name=?", new BeanHandler<Emp>(Emp.class), name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public void recoverEmp(Emp emp) {
		runner = MyUtils.getrunner();
		Integer id = emp.getId();
		String name = emp.getName();
		String password = emp.getPassword();
		String gender = emp.getGender();
		Integer age = emp.getAge();
		Date hiredate = emp.getHiredate();
		Double salary = emp.getSalary();
		String phone = emp.getPhone();
		String email = emp.getEmail();
		try {
			runner.update("insert into emp values(?,?,?,?,?,?,?,?,?)", id, name, password, gender, age, hiredate,
					salary, phone, email);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 通过id和name修改员工信息
	 */
	@Override
	public void updateEmp(Emp emp) {
		runner = MyUtils.getrunner();

		String name = emp.getName();
		String password = emp.getPassword();
		String gender = emp.getGender();
		Integer age = emp.getAge();
		Date hiredate = emp.getHiredate();
		Double salary = emp.getSalary();
		String phone = emp.getPhone();
		String email = emp.getEmail();
		try {
			runner.update("update emp set password=?,gender=?,age=?,hiredate=?,salary=?,phone=?,email=? where name=?",
					password, gender, age, hiredate, salary, phone, email, name);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Emp> findBuFen(String name, String gender, String age) {
		runner = MyUtils.getrunner();
		List<Emp> list = new ArrayList<Emp>();
		try {
			if (name != null & gender != null & age != null) {

				list = runner.query("select * from emp where name=? and gender=? and age=?",
						new BeanListHandler<Emp>(Emp.class), name, gender, age);

			} else if (name != null & gender != null & age == null) {
				list = runner.query("select * from emp where name=? and gender=?", new BeanListHandler<Emp>(Emp.class),
						name, gender);

			} else if (name != null & gender == null & age != null) {
				list = runner.query("select * from emp where name=?  and age=?", new BeanListHandler<Emp>(Emp.class),
						name, age);

			} else if (name != null & gender == null & age == null) {
				list = runner.query("select * from emp where name=? ", new BeanListHandler<Emp>(Emp.class), name);

			} else if (name == null & gender != null & age != null) {
				list = runner.query("select * from emp where gender=? and age=?", new BeanListHandler<Emp>(Emp.class),
						gender, age);

			} else if (name == null & gender != null & age == null) {
				list = runner.query("select * from emp where  gender=? ", new BeanListHandler<Emp>(Emp.class), gender);

			} else if (name == null & gender == null & age != null) {
				list = runner.query("select * from emp where  age=?", new BeanListHandler<Emp>(Emp.class), age);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
