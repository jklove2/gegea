package com.zyz.empSys.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.zyz.empSys.utils.MyUtils;

public class Test1 {
	
	@Test
	public void  testConnection() throws SQLException {
		
		Connection connection = MyUtils.getconnection();
		System.out.println(connection);
	}
	

}
