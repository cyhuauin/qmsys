package com.cust.qmsys.dao.paper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.cust.qmsys.domain.Paper;
import com.cust.qmsys.utils.JDBCConnection;

public class AddPaper {
	private Connection con;
	//private Statement sta;
	public void addPaper(Paper paper) throws ClassNotFoundException, SQLException{
		/*
		String paperNum = paper.getPaperNum();
		String grade = paper.getGrade();
		String subject = paper.getSubject();
		int score = paper.getScore();
		String teacher = paper.getTeacher();
		Date date = new Date(paper.getDate().getTime());
		*/
		con = JDBCConnection.getConnection();
		String sql = ""+
					"insert into paper "+
					"(paperNum,grade,subject,score,teacher,date)"+
					"values("+
					"?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareCall(sql);
		ps.setString(1, paper.getPaperNum());
		ps.setString(2, paper.getGrade());
		ps.setString(3, paper.getSubject());
		ps.setInt(4, paper.getScore());
		ps.setString(5, paper.getTeacher());
		ps.setDate(6,new Date(paper.getDate().getTime()));
		ps.execute();
		JDBCConnection.close(con);
	}
}
