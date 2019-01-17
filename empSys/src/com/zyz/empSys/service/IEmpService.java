package com.zyz.empSys.service;

import java.util.List;

import com.zyz.empSys.domain.Emp;

/**
 * emp的service接口
 * 
 * @author Administrator
 *
 */

public interface IEmpService {
	/**
	 * 账户登录验证
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	Emp longin(String name, String password);

	/**
	 * 查找所有员工信息
	 * 
	 * @return
	 */
	List<Emp> findALL();

	/**
	 * 注册
	 * 
	 * @param emp
	 */
	void register(Emp emp);
   /**
    * 删除员工信息
    * @param name
    */
	void delete(String name);
/**
 * 通过姓名查找员工信息
 * @param name
 * @return
 */
Emp FindEmpByName(String name);
/**
 * 恢复员工
 * @param emp
 */
void recoverEmp(Emp emp);
/**
 * 修改员工信息
 * @param emp
 */
void updateEmp(Emp emp);
/**
 * 通过某个信息查询员工
 * @param name
 * @param gender
 * @param age
 * @return
 */
List<Emp> findBuFen(String name, String gender, String age);

}
