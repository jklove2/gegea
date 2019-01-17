package com.zyz.empSys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.service.IEmpService;
import com.zyz.empSys.service.impl.EmpService;

/**
 * 查询所有员工信息的servlet
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取全局参数配置
		ServletContext context = req.getServletContext();
		String encoding = context.getInitParameter("encoding");
		// 请求编码设置
		req.setCharacterEncoding(encoding);
		// 响应格式设置
		resp.setContentType("text/html;charset=" + encoding);

		HttpSession session = req.getSession();
		Object user = session.getAttribute("user");
		if (user == null) {
			resp.getWriter().write("您还为登录");
			resp.setHeader("refresh", "3;url=" + context.getContextPath() + "/login.jsp");
		}

		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		if ("".equals(name)) {
			name = null;
		}
		if ("".equals(gender)) {
			gender = null;
		}
		if ("".equals(age)) {
			age = null;
		}
		List<Emp> list = null;
		IEmpService service = new EmpService();
		if (name == null && gender == null && age == null) {
	
			list = service.findALL();

		} else {
			list = service.findBuFen(name, gender, age);
		}
	
		req.setAttribute("list", list);

		req.getRequestDispatcher("/empList.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
