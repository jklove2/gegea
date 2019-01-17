package com.zyz.empSys.web;

import java.io.IOException;

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

@WebServlet("/RecoverServlet")
@SuppressWarnings("serial")
public class RecoverServlet extends HttpServlet {

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
				System.out.println(session);
				
				Emp emp = (Emp) session.getAttribute("emp");
				System.out.println(emp);
				IEmpService  service = new EmpService();
				service.recoverEmp(emp);
				req.getRequestDispatcher("/EmpListServlet").forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
