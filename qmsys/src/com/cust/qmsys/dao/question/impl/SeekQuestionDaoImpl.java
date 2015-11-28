package com.cust.qmsys.dao.question.impl;

import com.cust.qmsys.dao.question.SeekQuestionDao;
import com.cust.qmsys.domain.Question;
import com.cust.qmsys.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeekQuestionDaoImpl implements SeekQuestionDao {
    private Connection conn = null;
    private java.sql.Statement sta = null;
    private ResultSet rst = null;

    @Override
	public List seekQuestion(Integer type,  Integer zhangjie,Integer nandu,
                             String subname) {
        String sql = "";
        String body = "";
        String biaoming = "";
        switch (type) {
            case 1:
                biaoming = "ty_choice";
                break;
            case 2:
                biaoming = "ty_judge";
                break;
            case 3:
                biaoming = "ty_completion";
                break;
            case 4:
                biaoming = "ty_anquestion";
                break;
            default:
                break;
        }

        List<Question> list = new ArrayList<Question>();

        System.out.println(zhangjie + "   ss   " + nandu+biaoming);

             sql =" SELECT * FROM "+biaoming+" WHERE CHAPTER='"+zhangjie+"'AND level="+nandu+"";
            System.out.println(sql);
                try {
            conn = JDBCConnection.getConnection();
            sta = conn.createStatement();
            rst = sta.executeQuery(sql);

            while (rst.next()) {


                Question qu = new Question();
                qu.setQid(rst.getLong("qid"));
                qu.setBody(rst.getString("Body"));
                qu.setScore(rst.getDouble("score"));
                qu.setChapter(rst.getInt("chapter"));
                qu.setLevel(rst.getInt("level"));
                qu.setType(type);
                list.add(qu);
                System.out.println(list.size());
            }
            conn.close();
            sta.close();
            rst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }


}
