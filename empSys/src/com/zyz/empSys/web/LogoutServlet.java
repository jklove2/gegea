package com.zyz.empSys.web;

import java.io.IOException;
import java.util.function.LongToIntFunction;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {

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
		session.setMaxInactiveInterval(0);
		resp.sendRedirect("http://localhost:8080/"+context.getContextPath()+"/login.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
