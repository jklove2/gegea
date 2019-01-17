package com.zyz.empSys.service.impl;

import java.util.List;

import com.zyz.empSys.dao.IEmpDao;
import com.zyz.empSys.dao.impl.EmpDao;
import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.service.IEmpService;
/**
 * emp的service实现类
 */
public class EmpService implements IEmpService {
         IEmpDao dao = new EmpDao();
	@Override
	public Emp longin(String name, String password) {
		
		return dao.FindEmpByNameAndPassword(name,password);
	}
	@Override
	public List<Emp> findALL() {
		
		return dao.findALL();
	}
	@Override
	public void register(Emp emp) {
         dao.addEmp(emp);		
	}
	@Override
	public void delete(String name) {
		dao.deleteEmpByName(name);
		
	}
	@Override
	public Emp FindEmpByName(String name) {
		
		return dao.FindEmpByName(name);
	}
	@Override
	public void recoverEmp(Emp emp) {
 		 dao.recoverEmp(emp);
	}
	@Override
	public void updateEmp(Emp emp) {
		dao.updateEmp(emp);
		
	}
	@Override
	public List<Emp> findBuFen(String name, String gender, String age) {
		
		return dao.findBuFen(name,gender,age);
	}

}
