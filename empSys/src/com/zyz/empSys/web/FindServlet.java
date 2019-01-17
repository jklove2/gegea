package com.zyz.empSys.web;

import java.io.IOException;

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
 * 查询emp servlet
 * 
 * @author Administrator
 *
 */
@WebServlet("/FindServlet")
@SuppressWarnings("serial")
public class FindServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      ServletContext context = getServletContext();
      String encoding = context.getInitParameter("encoding");
      req.setCharacterEncoding(encoding);
      resp.setContentType("text/html;charset="+encoding);
      String name = req.getParameter("name");
      IEmpService service = new EmpService();
      Emp emp = service.FindEmpByName(name);
      req.setAttribute("emp", emp);
      req.getRequestDispatcher("/update.jsp").forward(req, resp);
      
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}

}
