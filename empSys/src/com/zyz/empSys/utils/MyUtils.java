package com.zyz.empSys.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyUtils {

	public static ComboPooledDataSource source = null;
	public static QueryRunner runner = null;
	public static Connection connection = null;

	static {

		source = new ComboPooledDataSource();
		runner = new QueryRunner(source);
	}

	public static QueryRunner getrunner() {

		return runner;
	}

	public static Connection getconnection() throws SQLException {
		return source.getConnection();
	}

}
