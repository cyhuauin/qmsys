package com.cust.qmsys.servlet.question;

import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;
import com.cust.qmsys.service.question.UpdateQuestionService;
import com.cust.qmsys.service.question.impl.UpdateQuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Դ on 2015/10/27.
 */

public class UpdateQuestionServlet extends HttpServlet {
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
       Long qid = Long.parseLong(request.getParameter("qid"));

        System.out.println(type+qid);
        String page = "WEB-INF/jsp/question/updatequestion.jsp";
        UpdateQuestionService uqs = new UpdateQuestionServiceImpl();
        switch (Integer.parseInt(type)){
            case 1:
                Choice ch = new Choice();
                ch.setQid(qid);
                ch.setBody(request.getParameter("body"));
                ch.setA(request.getParameter("A"));
                ch.setB(request.getParameter("B"));
                ch.setC(request.getParameter("C"));
                ch.setD(request.getParameter("D"));
//                ch.setSubject(request.getParameter());
                ch.setAnswer(request.getParameter("answer"));
//                ch.setCreateTime(request.getParameter("creatime"));
                if(request.getParameter("chapter") != null ){
                ch.setChapter(Integer.parseInt(request.getParameter("chapter")));
            }
//                ch.setCreateUser(request.getParameter("createuser"));
                ch.setImage(request.getParameter("image"));
                if(request.getParameter("level") != null )
                ch.setLevel(Integer.parseInt(request.getParameter("level")));
                if(request.getParameter("score") != null )
                ch.setScore(Double.parseDouble(request.getParameter("score")));
                
                uqs.updateChoice(ch);
                break;
            case 2:
                Judge judge = new Judge();
                judge.setQid(qid);
                judge.setBody(request.getParameter("body"));
                
//                judge.setSubject(request.getParameter());
                judge.setAnswer(Integer.parseInt(request.getParameter("answer")));
//                judge.setCreateTime(request.getParameter("creatime"));
                if(request.getParameter("judgeapter") != null ){
                    judge.setChapter(Integer.parseInt(request.getParameter("judgeapter")));
                }
//                judge.setCreateUser(request.getParameter("createuser"));
                judge.setImage(request.getParameter("image"));
                if(request.getParameter("level") != null )
                    judge.setLevel(Integer.parseInt(request.getParameter("level")));
                if(request.getParameter("score") != null )
                    judge.setScore(Double.parseDouble(request.getParameter("score")));
              
                uqs.updateJudge(judge);
                break;
            case 3:
                Completion comp = new Completion(); 
                comp.setQid(qid);
                comp.setBody(request.getParameter("body"));

//                comp.setSubject(request.getParameter());
                comp.setAnswer(request.getParameter("answer"));
//                comp.setCreateTime(request.getParameter("creatime"));
                if(request.getParameter("compapter") != null ){
                    comp.setChapter(Integer.parseInt(request.getParameter("compapter")));
                }
//                comp.setCreateUser(request.getParameter("createuser"));
                comp.setImage(request.getParameter("image"));
                if(request.getParameter("level") != null )
                    comp.setLevel(Integer.parseInt(request.getParameter("level")));
                if(request.getParameter("score") != null )
                    comp.setScore(Double.parseDouble(request.getParameter("score")));

                uqs.updateCompletion(comp);
                break;
            case 4:
                AnswerQuestion anq =new AnswerQuestion();
                anq.setQid(qid);
                anq.setBody(request.getParameter("body"));

//                anq.setSubject(request.getParameter());
                anq.setAnswer(request.getParameter("answer"));
//                anq.setCreateTime(request.getParameter("creatime"));
                if(request.getParameter("anqapter") != null ){
                    anq.setChapter(Integer.parseInt(request.getParameter("anqapter")));
                }
//                anq.setCreateUser(request.getParameter("createuser"));
                anq.setImage(request.getParameter("image"));
                if(request.getParameter("level") != null )
                    anq.setLevel(Integer.parseInt(request.getParameter("level")));
                if(request.getParameter("score") != null )
                    anq.setScore(Double.parseDouble(request.getParameter("score")));

                uqs.updateAnswerQuestion(anq);
                break;
            default:
                break;

        }
        request.getRequestDispatcher(page).forward(request,response);
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
