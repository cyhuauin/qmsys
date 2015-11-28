package com.cust.qmsys.servlet.subject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.utils.JDBCConnection;


public class DeleteSubjectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		JDBCConnection db=new JDBCConnection();
		String sq1="delete from subject where id='"+id+"'";
		db.executeUpdate(sq1);
		request.getRequestDispatcher("ListSubjectServlet").forward(request, response);
//
    }

}
