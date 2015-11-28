package com.cust.qmsys.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.domain.User;
import com.cust.qmsys.service.user.UserService;
import com.cust.qmsys.service.user.impl.UserServiceImpl;

public class UserLoginServlet extends HttpServlet {

	private static final long serialVersionUID = -1785256415709112302L;
	private UserService userService = null;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String uid =  req.getParameter("uid");
		String password = req.getParameter("password");
		String usex =  req.getParameter("usex");
		String phone =  req.getParameter("phone");
		String email =req.getParameter("email");
		String subjects = req.getParameter("sujects");
		System.out.println("进入添加用户功能");
		System.out.println(username);
		System.out.println(uid);
		System.out.println( password);
		System.out.println(usex);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(subjects);
		
		userService = new UserServiceImpl();
		User user = userService.userLogin(username);
		if (user == null) {
			req.setAttribute("info", "用户名不存在。");
			req.getRequestDispatcher("").forward(req, resp);
		} else {
			if (password.equals(user.getPassword())) {
				req.getSession().setAttribute("user", user);
				req.getRequestDispatcher("WEB-INF/jsp/test.jsp").forward(req, resp);
			} else {
				req.setAttribute("info", "密码错误，请核对后重新输入。");
			}
		}
	}

}
