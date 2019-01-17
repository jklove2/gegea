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

/**
 * 删除servlet
 * 
 * @author Administrator
 *
 */
@WebServlet("/DeleteServlet")
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String encoding = context.getInitParameter("encoding");
		req.setCharacterEncoding(encoding);
		resp.setContentType("text/html;charset=" + encoding);
		String name = req.getParameter("name");
		System.out.println(name);
		IEmpService service = new EmpService();
		Emp emp =service.FindEmpByName(name);
		HttpSession session = req.getSession();
		 session.setMaxInactiveInterval(-1);
		 session.setAttribute("emp", emp);
		service.delete(name);
		
		req.getRequestDispatcher("/EmpListServlet").forward(req, resp);
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
