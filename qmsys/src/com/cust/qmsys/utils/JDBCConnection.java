package com.cust.qmsys.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cust.qmsys.domain.User;
import com.mysql.jdbc.ResultSetMetaData;

public class JDBCConnection {
	private static String url = "jdbc:mysql://localhost:3306/dbtest";
	private static String user = "root";
	private static String pass = "root";
	private static Connection conn = null;

	public static Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static int close(Connection conn) {
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return 0;
			}
		}
		return 1;
	}

	public static int close(Statement st) {
		if (null != st) {
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return 0;
			}
		}
		return 1;
	}

	public static int close(ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return 0;
			}
		}
		return 1;
	}
	public static int executeUpdate(String sql){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConnection().createStatement();
			return stmt.executeUpdate(sql);//更新并返回
		} catch (ClassNotFoundException e) {
			System.out.println("数据库更新失败");
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			System.out.println("数据库更新失败");
			e.printStackTrace();
			return 0;
		}finally{
			close(conn);
			close(rs);
			close(stmt);
		}
		
	}
	
	//查询结果集的方法
	public static ResultSet query(String sql){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();//生成语句对象
			rs = stmt.executeQuery(sql);
			return rs;
		}  catch (ClassNotFoundException e) {
			System.out.println("查询结果集失败");
			e.printStackTrace();
			return null;
		}catch (SQLException e) {
			System.out.println("查询结果集失败");
			e.printStackTrace();
			return null;
		}finally{
			close(conn);
			close(rs);
			close(stmt);
		}
	}
	
	//苏
	public List<Map<String,Object>> query1(String sql) {
		Statement stmt = null;
		ResultSet rs = null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			try {
				stmt = getConnection().createStatement();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = stmt.executeQuery(sql);
			/*------将结果集rs转化为List<Map<String,Object>>-----*/
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int count = rsmd.getColumnCount();//获得结果集中字段的个数
			
			while(rs.next()){
				Map<String,Object> map = new HashMap<String,Object>();
				for(int i = 0 ; i < count ; i++){
					String key = rsmd.getColumnName(i+1);
					Object value = rs.getObject(key);
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally{
			close(stmt);
		}
		return list;
	}

	//张
	public int insert(User user) {
		Connection conn=null;
		PreparedStatement ps= null;
		int i = 0;
		String sql  ="insert into tbl_user (uid,userame,usex,phone,subjects,email,password)values(?,?,?,?,?,?,?)";
		try{
			try {
				conn = JDBCConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps = conn.prepareStatement(sql);
			ps.setLong(1, user.getUid());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getUsex());
			ps.setString(4, user.getPhone());
			ps.setObject(5,user.getSubjects());
			ps.setString(6,user.getEmail());
			ps.setString(7,user.getPassword());
			i = ps.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}
		return i;
	}

}
