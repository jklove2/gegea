package com.zyz.empSys.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.service.IEmpService;
import com.zyz.empSys.service.impl.EmpService;

/**
 * 修改servlet
 * 
 * @author Administrator
 *
 */
@WebServlet("/UpdateServlet")
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String encoding = context.getInitParameter("encoding");
		req.setCharacterEncoding(encoding);
		resp.setContentType("text/html;charset=" + encoding);
		HttpSession session = req.getSession();
		Object user = session.getAttribute("user");
		if(user == null) {
			resp.getWriter().write("您还为登录");
			resp.getWriter().write("注册成功，3秒后跳转到登录页面，请稍等片刻");
			resp.setHeader("refresh", "3;url=" + context.getContextPath() + "/login.jsp");
		}

		String name = req.getParameter("name");
		String password = req.getParameter("password1");
		String gender = req.getParameter("gender");
		Integer age = Integer.parseInt(req.getParameter("age"));
		Double salary = Double.parseDouble(req.getParameter("salary"));
		String phone = req.getParameter("phone");
		Date hiredate = new Date(System.currentTimeMillis());
		String email = req.getParameter("email");
		
		Emp emp = new Emp(1, name, password, gender, age, hiredate, salary, phone, email);
		IEmpService service = new EmpService();
		service.updateEmp(emp);
		req.getRequestDispatcher("/EmpListServlet").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}

}
