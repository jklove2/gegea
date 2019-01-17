package com.zyz.empSys.dao;

import java.util.List;

import com.zyz.empSys.domain.Emp;

/**
 * emp实体类的dao接口
 * 
 * @author Administrator
 *
 */
public interface IEmpDao {
	/**
	 * 通过姓名和密码查询
	 */
	Emp FindEmpByNameAndPassword(String name, String password);

	/**
	 * 查询所有员工的信息
	 * 
	 * @return
	 */
	List<Emp> findALL();

	/**
	 * 添加员工
	 * 
	 * @param emp
	 */
	void addEmp(Emp emp);
    /**
     * 
     * @param name
     */
	void  deleteEmpByName(String name);
    /**
     * 通过姓名查找员工
     * @param name
     * @return
     */
	Emp FindEmpByName(String name);
  /**
   * 恢复员工信息
   * @param emp
   */
	void recoverEmp(Emp emp);
/**
 * 修改员工信息
 * @param emp
 */
void updateEmp(Emp emp);
/**
 * 根据参数查询员工信息
 * @param name
 * @param gender
 * @param age
 * @return
 */
List<Emp> findBuFen(String name, String gender, String age);

}
