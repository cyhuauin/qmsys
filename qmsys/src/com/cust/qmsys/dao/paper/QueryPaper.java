package com.cust.qmsys.dao.paper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cust.qmsys.domain.Paper;
import com.cust.qmsys.utils.JDBCConnection;

public class QueryPaper {
	private Connection con;
	public List<Paper> query() throws ClassNotFoundException, SQLException{
		con = JDBCConnection.getConnection();
		String sql = "select * from paper";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Paper> list = new ArrayList<Paper>();
		Paper paper = null;
		while(rs.next()){
			paper = new Paper();
			paper.setPaperNum(rs.getString("paperNUm"));
			paper.setGrade(rs.getString("grade"));
			paper.setSubject(rs.getString("subject"));
			paper.setScore(rs.getInt("score"));
			paper.setTeacher(rs.getString("teacher"));
			paper.setDate(rs.getDate("date"));
			list.add(paper);
		}
		JDBCConnection.close(con);
		return list;
	}
}
