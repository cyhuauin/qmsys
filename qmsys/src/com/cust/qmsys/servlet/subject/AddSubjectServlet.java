package com.cust.qmsys.servlet.subject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.dao.subject.impl.SubjectDaoImpl;
import com.cust.qmsys.domain.Subject;

public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 8917840811689681144L;
	String page = null;
	private Subject subject;
	
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sname = request.getParameter("sname");
		request.setCharacterEncoding("UTF-8");
		SubjectDaoImpl sub = new SubjectDaoImpl();
		sub.addSubject(sname);
		//Ìø×ª
		page = "/WEB-INF/jsp/subject/addsubject.jsp";
		request.getRequestDispatcher(page).forward(request, response);

    }
}
