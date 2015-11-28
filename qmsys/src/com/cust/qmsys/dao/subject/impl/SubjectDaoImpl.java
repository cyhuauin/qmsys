package com.cust.qmsys.dao.subject.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.cust.qmsys.dao.subject.SubjectDao;
import com.cust.qmsys.domain.Subject;
import com.cust.qmsys.utils.JDBCConnection;

public class SubjectDaoImpl implements SubjectDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	
	//添加科目
	@Override
	public Subject addSubject(String sname) {
		String sql = "insert into subject(name) values('"+sname+"')";
		try {
			conn = JDBCConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}
		return null;
	}
	
	//刷新科目
	
	@Override
	public List<Map<String, Object>> list() {
		 JDBCConnection db = new JDBCConnection();
		 String sql = "select * from subject";
		List<Map<String, Object>> list = db.query1(sql);
		System.out.print(list+"&&&&&&&&");
		return list;
	}
	
	
	
	//修改科目
    public Subject updateSubject(String sname) {
    	
	String sql = "update subject set name ='"+sname+"'";
	try {
		conn = JDBCConnection.getConnection();
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JDBCConnection.close(rs);
		JDBCConnection.close(ps);
		JDBCConnection.close(conn);
	}
	return null;
    }
    
    
    
}




