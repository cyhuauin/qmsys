package com.cust.qmsys.dao.question.impl;

import com.cust.qmsys.dao.question.UpdateQuestionDao;
import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;
import com.cust.qmsys.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Դ on 2015/10/28.
 */
public class UpdateQuestionDaoImpl implements UpdateQuestionDao {

    private Connection conn = null;
    private java.sql.Statement sta = null;
    @Override
	public Integer updateChoice(Choice choice) {
        String sql = "UPDATE ty_choice set body = "+choice.getBody()+",";
        sql = sql + "a = "+choice.getA()+", b = "+choice.getB()+" ,";
        sql = sql + "c = "+choice.getC()+", d = "+choice.getD()+",";
        sql = sql + "answer = "+choice.getAnswer()+", score = "+choice.getScore()+" ,";
        sql = sql + "level = "+choice.getLevel()+", chapter = "+choice.getChapter()+",";
        sql = sql + "image = "+choice.getImage()+"";
        sql = sql + " WHERE qid = "+choice.getQid()+"";
        System.out.println(sql);
        try {
            conn = JDBCConnection.getConnection();
            sta = conn.createStatement();
            sta.executeUpdate(sql);

            if (sta != null)
                return 1;
        }catch (ClassNotFoundException c){
            c.printStackTrace();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCConnection.close(conn);
            JDBCConnection.close(sta);
        }


        return 0;
    }

    @Override
    public Integer updateJudge(Judge judge) {
        String sql = "UPDATE ty_judge set body = "+judge.getBody()+",";
        sql = sql + "answer = "+judge.getAnswer()+", score = "+judge.getScore()+",";
        sql = sql + "level = "+judge.getLevel()+", chapter = "+judge.getChapter()+"";
        sql = sql + "image = "+judge.getImage()+"";
        sql = sql + " WHERE qid = "+judge.getQid()+"";
        System.out.println(sql);
        try {
            conn = JDBCConnection.getConnection();
            sta = conn.createStatement();
            sta.executeUpdate(sql);

            if (sta != null)
                return 1;
        }catch (ClassNotFoundException c){
            c.printStackTrace();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCConnection.close(conn);
            JDBCConnection.close(sta);
        }


        return 0;
        
    }

    @Override
    public Integer updateCompletion(Completion compl) {
        String sql = "UPDATE ty_compl set body = "+compl.getBody()+",";
        sql = sql + "answer = "+compl.getAnswer()+", score = "+compl.getScore()+",";
        sql = sql + "level = "+compl.getLevel()+", chapter = "+compl.getChapter()+"";
        sql = sql + "image = "+compl.getImage()+"";
        sql = sql + " WHERE qid = "+compl.getQid()+"";
        System.out.println(sql);
        try {
            conn = JDBCConnection.getConnection();
            sta = conn.createStatement();
            sta.executeUpdate(sql);

            if (sta != null)
                return 1;
        }catch (ClassNotFoundException c){
            c.printStackTrace();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCConnection.close(conn);
            JDBCConnection.close(sta);
        }


        return 0;
    }

    @Override
    public Integer updateAnswerQuestion(AnswerQuestion aq) {
        String sql = "UPDATE ty_aq set body = "+aq.getBody()+",";
        sql = sql + "answer = "+aq.getAnswer()+", score = "+aq.getScore()+",";
        sql = sql + "level = "+aq.getLevel()+", chapter = "+aq.getChapter()+"";
        sql = sql + "image = "+aq.getImage()+"";
        sql = sql + " WHERE qid = "+aq.getQid()+"";
        System.out.println(sql);
        try {
            conn = JDBCConnection.getConnection();
            sta = conn.createStatement();
            sta.executeUpdate(sql);

            if (sta != null)
                return 1;
        }catch (ClassNotFoundException c){
            c.printStackTrace();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCConnection.close(conn);
            JDBCConnection.close(sta);
        }


        return 0;
    }
}
