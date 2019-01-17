package com.zyz.empSys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.service.IEmpService;
import com.zyz.empSys.service.impl.EmpService;

@WebServlet("/loginServlet")
@SuppressWarnings("serial")
/**
 * 登录servlet
 * 
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取全局参数配置
		ServletContext context = req.getServletContext();
		String encoding = context.getInitParameter("encoding");
		// 请求编码设置
		req.setCharacterEncoding(encoding);
		// 响应格式设置
		resp.setContentType("text/html;charset=" + encoding);
		// 获取请求参数
		String name = req.getParameter("name");
		String password = req.getParameter("password");

		// 调用service方法进行登录
		IEmpService service = new EmpService();
		Emp emp = service.longin(name, password);
		
		// 登录成功
		if (emp != null) {
			// 把登录用户的信息存入session中，表示一次回话开始
			HttpSession session = req.getSession();
			session.setAttribute("user", emp);
			
			// 按照设定格式获取当前时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
			String lastTime = sdf.format(new Date());

			Cookie[] cookies = req.getCookies();
			// 非第一次访问服务器
			if (cookies != null) {
				Cookie c = null;
				for (Cookie cookie : cookies) {

					String cookieName = cookie.getName();
					if ("lastTime".equals(cookieName)) {
						c = cookie;
						break;
					}

				}
				// 非第一次登录
				if (c != null) {
					String value = c.getValue();
					
					req.setAttribute("lastTime", value);
					c.setValue(lastTime);
					resp.addCookie(c);
					// 请求转发，目的是将请求参数发送过去
					
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
				} else // 第一次登录
				{
					c = new Cookie("lastTime", lastTime);
					// 设置cookie为全站参数及cookie的生命时间
					c.setPath("/");
					c.setMaxAge(60 * 60 * 24 * 365);
					req.setAttribute("lastime", lastTime);
					resp.addCookie(c);
					req.setAttribute("lastTime", lastTime);
					req.getRequestDispatcher("/index.jsp").forward(req, resp);

				}
				// 此客服端第一次访问服务器
			} else {

				Cookie c = new Cookie("lastTime", lastTime);
				// 设置cookie
				c.setPath("/");
				c.setMaxAge(60 * 60 * 24 * 365);
				req.setAttribute("lastime", lastTime);
				resp.addCookie(c);
				
				req.getRequestDispatcher("/index.jsp").forward(req, resp);

			}

			// 登录成功，设置3秒后自动跳转到主页
			resp.getWriter().write("登录成功，3秒后跳转到主页，请稍等片刻...");
			
			resp.setHeader("refresh", "3;url=" + context.getContextPath() + "/index.jsp");

			return;

		} // 未登录成功，转到登录页面
		else {
			req.setAttribute("error_msg", "账户或密码有误，请检查后重新登录");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);

			return;

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
