package com.cust.qmsys.dao.paper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cust.qmsys.domain.Paper;
import com.cust.qmsys.utils.JDBCConnection;

public class DelPaper {
	private Connection con;
	public void delPaper(Paper paper) throws ClassNotFoundException, SQLException{
		con = JDBCConnection.getConnection();
		String sql = ""+
					" delete from paper"+
					" where paperNum = ?";
		PreparedStatement ps = con.prepareCall(sql);
		ps.setString(1, paper.getPaperNum());
		ps.execute();
		JDBCConnection.close(con);
	}

}
