package com.cust.qmsys.servlet.subject;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.utils.JDBCConnection;


public class QueryOneSubjetServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		request.setCharacterEncoding("UTF-8");
		JDBCConnection db=new JDBCConnection();
		String sq1="select*from subject where id='"+id+"'";
		Map<String,Object>map=db.query1(sq1).get(0);
		request.setAttribute("map", map);
		System.out.print(map+"我在这里");
        //
		request.getRequestDispatcher("WEB-INF/jsp/subject/updatesubject1.jsp").forward(request, response);

    }

}
