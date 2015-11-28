package com.cust.qmsys.servlet.paper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.dao.paper.AddPaper;
import com.cust.qmsys.domain.Paper;

/**
 * Servlet implementation class AddPaperServlet
 */
public class AddPaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String paperNum = request.getParameter("paperID");
		String grade = request.getParameter("grade");
		String subject = request.getParameter("subject");
		int score = Integer.parseInt(request.getParameter("score"));
		String teacher = request.getParameter("paperTeacher");
		
		Paper paper = new Paper();
		paper.setPaperNum(paperNum);
		paper.setGrade(grade);
		paper.setSubject(subject);
		paper.setScore(score);
		paper.setTeacher(teacher);
		paper.setDate(new Date());
		
		AddPaper addpaper = new AddPaper();
		try {
			addpaper.addPaper(paper);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//request.setAttribute("mes", "添加成功！");
		//request.getRequestDispatcher("/WEB-INF/jsp/paper/addPaper.jsp").forward(request, response);
		/*
		PrintWriter out = response.getWriter();
		out.println("<script language='javascript'>");
		out.println("alert('添加成功');");
		out.println("</script>");
		*/
		String page = "/WEB-INF/jsp/paper/addPaper.jsp";
		request.getRequestDispatcher(page).forward(request, response);
	}

}
