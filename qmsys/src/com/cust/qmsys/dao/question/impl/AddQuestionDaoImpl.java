package com.cust.qmsys.dao.question.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.cust.qmsys.dao.question.AddQuestionDao;
import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;
import com.cust.qmsys.utils.JDBCConnection;
import com.mysql.jdbc.Statement;

public class AddQuestionDaoImpl implements AddQuestionDao{
	private Connection conn = null;
	
	private Statement sta = null; 
	@Override
	public Choice addChoice(Choice choice){
	    
		String body = choice.getBody();
		String A = choice.getA();
		String B = choice.getB();
		String C = choice.getC();
		String D = choice.getD();
		String Answer = choice.getAnswer();
		Double Score = choice.getScore();
		Integer level = choice.getLevel();
		Integer chapter = choice.getChapter();
        String image = choice.getImage();
		System.out.println(body);
		System.out.println(A);
		String sql = "INSERT INTO ty_choice (type,body,a,b,c,d,answer,score,level,chapter,image) VALUES('1',"
				+ "'"+body+"','"+A+"','"+B+"','"+C+"','"+D+"','"+Answer+"','"+Score+"','"+level+"','"+chapter+"','"+image+"')";
		try {
			conn = JDBCConnection.getConnection();
			sta = (Statement) conn.createStatement();
			sta.executeUpdate(sql);
			sta.close();
			conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCConnection.close(sta);
				
				JDBCConnection.close(conn);
			}
		return choice;

}

    @Override
    public Judge addJudge(Judge judge) {
        String body = judge.getBody();
        Integer answer = judge.getAnswer();
        Double Score = judge.getScore();
        Integer level = judge.getLevel();
        Integer chapter = judge.getChapter();
        String image = judge.getImage();
        String sql = "INSERT INTO ty_judge (type,body,answer,score,level,chapter,image) VALUES('2',"
                + "'"+body+"','"+answer+"','"+Score+"','"+level+"','"+chapter+"','"+image+"')";
        try {
            conn = JDBCConnection.getConnection();
            sta = (Statement) conn.createStatement();
            sta.executeUpdate(sql);
            sta.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JDBCConnection.close(sta);

            JDBCConnection.close(conn);
        }

        return judge;
    }

    @Override
    public Completion addCompletion(Completion cmp) {
        String body = cmp.getBody();
        String answer = cmp.getAnswer();
        Double Score = cmp.getScore();
        Integer level = cmp.getLevel();
        Integer chapter = cmp.getChapter();
        String image = cmp.getImage();
        String sql = "INSERT INTO ty_completion(type,body,answer,score,level,chapter£¬image) VALUES('3',"
                + "'"+body+"','"+answer+"','"+Score+"','"+level+"','"+chapter+"','"+image+"')";
        try {
            conn = JDBCConnection.getConnection();
            sta = (Statement) conn.createStatement();
            sta.executeUpdate(sql);
            sta.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JDBCConnection.close(sta);

            JDBCConnection.close(conn);
        }



        return cmp;
    }

    @Override
    public AnswerQuestion addAnswerQuestion(AnswerQuestion anq) {
        String body = anq.getBody();
        String answer = anq.getAnswer();
        Double Score = anq.getScore();
        Integer level = anq.getLevel();
        Integer chapter = anq.getChapter();
        String image = anq.getImage();
        String sql = "INSERT INTO ty_anquestion (type,body,answer,score,level,chapter,image) VALUES('2',"
                + "'"+body+"','"+answer+"','"+Score+"','"+level+"','"+chapter+"','"+image+"')";
        try {
            conn = JDBCConnection.getConnection();
            sta = (Statement) conn.createStatement();
            sta.executeUpdate(sql);
            sta.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JDBCConnection.close(sta);

            JDBCConnection.close(conn);
        }



        return anq;
    }
}
