package com.cust.qmsys.dao.user.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cust.qmsys.dao.user.UserDao;
import com.cust.qmsys.domain.User;
import com.cust.qmsys.utils.JDBCConnection;

public   class UserDaoImpl implements UserDao {
	
	
	//查询
	@Override
	public User query(String username) {
		String sql = "SELECT * FROM adduser WHERE username = ?";
		User user = null;
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try{

				conn = JDBCConnection.getConnection();

            ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUid(rs.getLong("uid"));
				user.setUsex(rs.getString("usex"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setSubjects(rs.getString("subjects"), null);//
			
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}

		return user;
	}
	//插入
	@Override
	public int insert(User user) {
		Connection conn=null;
		PreparedStatement ps= null;
		int i = 0;
		String sql  ="insert into adduser (uid,userame,usex,phone,subjects,email,password)values(?,?,?,?,?,?,?)";
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
	//删除
	@Override
	public  int delete(String uid){
		String sql = "delete from adduser where u_id ="+uid;
		Connection conn=null;
		PreparedStatement ps= null;
		int i = 0;
		try {
			try {
				conn = JDBCConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
			System.out.println("resutl"+i);
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}

		return i;
	}
	//修改
	@Override
	public  int update(User user){
		Connection conn=null;
	 	PreparedStatement ps= null;
		int i = 0;
		String sql = "update adduser (uid,password,userame,usex,phone,subjects,email) set u_name= ?where u_id = ?";
		try{
			try {
				conn = JDBCConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps=conn.prepareStatement(sql);
			i = ps.executeUpdate();
			System.out.println("resutl:"+ i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}

		return i ;
	}


	
}
//张赫
