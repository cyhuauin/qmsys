package com.cust.qmsys.dao.question.impl;

import com.cust.qmsys.dao.question.DetailQuestionDao;
import com.cust.qmsys.domain.User;
import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;
import com.cust.qmsys.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Դ on 2015/10/25.
 */
public class DetailQuestionDaoImpl implements DetailQuestionDao {
    private Connection conn = null;
    private java.sql.Statement sta = null;
    private ResultSet rst = null;
    User user = new User();
    @Override
	public Object getQuestion(String table,Long qid){

        String sql = "SELECT * FROM "+table+" WHERE QID = "+qid+"";
        System.out.println(sql);
        Object obj = null;
        switch (table){
            case "ty_choice":

                obj = getChoice(sql);
                break;
            case "ty_judge":
                obj = getJudge(sql);
                break;
            case "ty_completion":
                obj = getCompletion(sql);
                break;
            case "ty_answerquestion":
                obj = getAnswerQuestion(sql);
                break;
            default:
                break;
        }

        return obj;
    }
    public Choice getChoice(String sql){
        Choice choice = new Choice();
     
        try{
            conn = JDBCConnection.getConnection();
            sta = conn.createStatement();
            rst = sta.executeQuery(sql);
            while (rst.next()){
                choice.setQid(rst.getLong("qid"));
                choice.setBody(rst.getString("Body"));
                choice.setA(rst.getString("a"));
                choice.setB(rst.getString("b"));
                choice.setC(rst.getString("c"));
                choice.setD(rst.getString("d"));
                choice.setE(rst.getString("e"));
                choice.setF(rst.getString("f"));
                choice.setAnswer(rst.getString("answer"));
                choice.setScore(rst.getDouble("score"));
                choice.setChapter(rst.getInt("chapter"));
                choice.setLevel(rst.getInt("level"));
                choice.setImage(rst.getString("image"));
                choice.setCreateTime(rst.getDate("create_time"));
                choice.setMulti_Choice(rst.getInt("multi_choice"));
//                choice.setCreateUser();
//                choice.setSubject();
                choice.setType(1);
            }
            conn.close();
            sta.close();
            rst.close();

        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }catch(SQLException s){
            s.printStackTrace();
        }



        return choice;
    }
    public Judge getJudge(String sql){
        Judge judge = new Judge();
       
        try{
            conn = JDBCConnection.getConnection();
            sta = conn.createStatement();
            rst = sta.executeQuery(sql);
            while (rst.next()){
                judge.setQid(rst.getLong("qid"));
                judge.setBody(rst.getString("Body"));
               
                judge.setAnswer(rst.getInt("answer"));
                judge.setScore(rst.getDouble("score"));
                judge.setChapter(rst.getInt("chapter"));
                judge.setLevel(rst.getInt("level"));
                judge.setImage(rst.getString("image"));
                judge.setCreateTime(rst.getDate("create_time"));
            
//                judge.setCreateUser();
//                judge.setSubject();
                judge.setType(1);
            }
            conn.close();
            sta.close();
            rst.close();

        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }catch(SQLException s){
            s.printStackTrace();
        }



        return judge;
    }
    public Completion getCompletion(String sql){
        Completion compl = new Completion();

        try{
            conn = JDBCConnection.getConnection();
            sta = conn.createStatement();
            rst = sta.executeQuery(sql);
            while (rst.next()){
                compl.setQid(rst.getLong("qid"));
                compl.setBody(rst.getString("Body"));

                compl.setAnswer(rst.getString("answer"));
                compl.setScore(rst.getDouble("score"));
                compl.setChapter(rst.getInt("chapter"));
                compl.setLevel(rst.getInt("level"));
                compl.setImage(rst.getString("image"));
                compl.setCreateTime(rst.getDate("create_time"));

//                compl.setCreateUser();
//                compl.setSubject();
                compl.setType(1);
            }
            conn.close();
            sta.close();
            rst.close();

        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }catch(SQLException s){
            s.printStackTrace();
        }



        return compl;
    }
    public AnswerQuestion getAnswerQuestion(String sql){
        AnswerQuestion anq= new AnswerQuestion();

        try{
            conn = JDBCConnection.getConnection();
            sta = conn.createStatement();
            rst = sta.executeQuery(sql);
            while (rst.next()){
                anq.setQid(rst.getLong("qid"));
                anq.setBody(rst.getString("Body"));

                anq.setAnswer(rst.getString("answer"));
                anq.setScore(rst.getDouble("score"));
                anq.setChapter(rst.getInt("chapter"));
                anq.setLevel(rst.getInt("level"));
                anq.setImage(rst.getString("image"));
                anq.setCreateTime(rst.getDate("create_time"));

//                anq.setCreateUser();
//                anq.setSubject();
                anq.setType(1);
            }
            conn.close();
            sta.close();
            rst.close();

        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }catch(SQLException s){
            s.printStackTrace();
        }



        return anq;
    }

}
