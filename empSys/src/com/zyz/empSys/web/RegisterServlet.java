package com.zyz.empSys.web;

import java.io.IOException;
import java.sql.Date;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.service.IEmpService;
import com.zyz.empSys.service.impl.EmpService;

/**
 * 注册servlet
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取全局参数配置
		ServletContext context = req.getServletContext();
		String encoding = context.getInitParameter("encoding");
		// 请求编码设置
		req.setCharacterEncoding(encoding);
	
		// 响应格式设置
		resp.setContentType("text/html;charset=" + encoding);

		String name = req.getParameter("name");
		String password = req.getParameter("password1");
		String gender = req.getParameter("gender");
		Integer age = Integer.parseInt(req.getParameter("age"));
		Double salary = Double.parseDouble(req.getParameter("salary"));
		String phone = req.getParameter("phone");

		Date hiredate = new Date(System.currentTimeMillis());
		String email = req.getParameter("email");
		Emp emp = new Emp(1, name, password, gender, age,  hiredate, salary, phone, email);
		IEmpService service = new EmpService();
		service.register(emp);
		resp.getWriter().write("注册成功，3秒后跳转到登录页面，请稍等片刻");
		resp.setHeader("refresh", "3;url=" + context.getContextPath() + "/login.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
