package com.cust.qmsys.servlet.paper;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.dao.paper.DelPaper;
import com.cust.qmsys.domain.Paper;

/**
 * Servlet implementation class DeletePaperServlet
 */
public class DeletePaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePaperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");
		/*
		String paperNum = request.getParameter("delID");
		Paper paper = new Paper();
		paper.setPaperNum(paperNum);
		
		DelPaper dl = new DelPaper();
		try {
			dl.delPaper(paper);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String page = "/WEB-INF/jsp/paper/delPaper.jsp";
		request.getRequestDispatcher(page).forward(request, response);
		*/
		
		
		String paperNum = request.getParameter("paperNum");
		System.out.println(paperNum);
		Paper paper = new Paper();
		paper.setPaperNum(paperNum);
		
		DelPaper dl = new DelPaper();
		try {
			dl.delPaper(paper);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String page = "/WEB-INF/jsp/paper/delPaper.jsp";
		request.getRequestDispatcher(page).forward(request, response);
		
	}

}
