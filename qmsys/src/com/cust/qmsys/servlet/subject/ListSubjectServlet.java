package com.cust.qmsys.servlet.subject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.dao.subject.SubjectDao;
import com.cust.qmsys.dao.subject.impl.SubjectDaoImpl;



public class ListSubjectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		    SubjectDao ss=new  SubjectDaoImpl();

			List<Map<String, Object>> list = ss.list();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("WEB-INF/jsp/subject/updatesubject.jsp").forward(request, response);
		//

    }

}
