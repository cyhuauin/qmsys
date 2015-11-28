package com.cust.qmsys.dao.question.impl;

import java.sql.SQLException;

import com.cust.qmsys.dao.question.DeleteQuestionDao;
import com.cust.qmsys.utils.JDBCConnection;
import com.mysql.jdbc.Statement;

public class DeleteQuestionDaoImpl implements DeleteQuestionDao{
    private java.sql.Connection conn = null;
    private Statement  st = null;
	@Override
	public boolean DelQuestion(long qid, String table) {
		String sql = "DELETE FROM "+table+" WHERE qid = "+qid+"";
		try{
			conn = JDBCConnection.getConnection();
			st = (Statement) conn.createStatement();
			System.out.println(sql);
			int result = st.executeUpdate(sql);
			if(result > 0 ){
				return true;
			}
			
			
		}catch(SQLException s){
			s.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			JDBCConnection.close(st);
			
			JDBCConnection.close(conn);
		}
	   return false;
	}
	
}


