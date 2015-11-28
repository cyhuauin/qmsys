package com.cust.qmsys.servlet.menuitem;

import com.cust.qmsys.service.subject.SubjectService;
import com.cust.qmsys.service.subject.impl.SubjectServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuitemForwardServlet extends HttpServlet{
	private static final long serialVersionUID = -5987656732889522737L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String page = req.getParameter("page");
		System.out.println("WEB-INF/jsp"+page);
        SubjectService ss = new SubjectServiceImpl();
        List<Map<String,Object>> li = ss.FindallSubject();
        req.setAttribute("sublist",li);
        if (page.endsWith(".jsp")) {
            req.getRequestDispatcher("WEB-INF/jsp"+page).forward(req, resp);
        } else {
            System.out.println("ceshi");
            req.getRequestDispatcher(page).forward(req, resp);
        }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
