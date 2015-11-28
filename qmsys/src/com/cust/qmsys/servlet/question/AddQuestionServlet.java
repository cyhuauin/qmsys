package com.cust.qmsys.servlet.question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.domain.Subject;
import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;
import com.cust.qmsys.service.question.AddQuestionService;
import com.cust.qmsys.service.question.impl.AddQuestionServiceImpl;

/**
 * Servlet implementation class add
 */
public class AddQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer type = 0;
        Boolean su = null;
        String page = null;
        String filename = "";
        String imagename = request.getParameter("image");
        Subject sub = new Subject();


        AddQuestionService aqs = new AddQuestionServiceImpl();


        type = Integer.parseInt(request.getParameter("type"));
        if (type == 1) {
            Choice choice = new Choice();

            choice.setSubject(sub);
            choice.setBody(request.getParameter("body"));
            choice.setA(request.getParameter("A"));
            choice.setB(request.getParameter("B"));
            choice.setC(request.getParameter("C"));
            choice.setD(request.getParameter("D"));
            choice.setImage(filename);
            choice.setAnswer(request.getParameter("answer"));
            choice.setScore(Double.parseDouble(request.getParameter("score")));
            choice.setLevel(Integer.parseInt(request.getParameter("level")));
            choice.setChapter(Integer.parseInt(request.getParameter("chapter")));
            //少图片和出题人 出题时间 候补

            su = aqs.addChoice(choice, type);
        } else if (type == 2) {
            Judge judge = new Judge();
            judge.setSubject(sub);
            judge.setBody(request.getParameter("body"));
            judge.setAnswer(Integer.parseInt(request.getParameter("answer")));
            judge.setType(type);
            judge.setScore(Double.parseDouble(request.getParameter("score")));
//            judge.setImage();
            judge.setLevel(Integer.parseInt(request.getParameter("level")));
            judge.setChapter(Integer.parseInt(request.getParameter("chapter")));
            su = aqs.addJudge(judge, type);
        } else if (type == 2) {
            Judge judge = new Judge();
            judge.setSubject(sub);
            judge.setBody(request.getParameter("body"));
            judge.setAnswer(Integer.parseInt(request.getParameter("answer")));
            judge.setType(type);
            judge.setScore(Double.parseDouble(request.getParameter("score")));
//            judge.setImage();
            judge.setLevel(Integer.parseInt(request.getParameter("level")));
            judge.setChapter(Integer.parseInt(request.getParameter("chapter")));
            su = aqs.addJudge(judge, type);
        } else if (type == 3) {
            Completion comp = new Completion();
            comp.setSubject(sub);
            comp.setBody(request.getParameter("body"));
            comp.setAnswer(request.getParameter("answer"));
            comp.setType(type);
            comp.setScore(Double.parseDouble(request.getParameter("score")));
//            comp.setImage();
            comp.setLevel(Integer.parseInt(request.getParameter("level")));
            comp.setChapter(Integer.parseInt(request.getParameter("chapter")));
            su = aqs.addCompletion(comp, type);
        } else if (type == 4) {
            AnswerQuestion anq = new AnswerQuestion();
            anq.setSubject(sub);
            anq.setBody(request.getParameter("body"));
            anq.setAnswer(request.getParameter("answer"));
            anq.setType(type);
            anq.setScore(Double.parseDouble(request.getParameter("score")));
//            anq.setImage();
            anq.setLevel(Integer.parseInt(request.getParameter("level")));
            anq.setChapter(Integer.parseInt(request.getParameter("chapter")));
            su = aqs.addAnswerQuestion(anq, type);
        }
        if (su == true) {
            page = "/WEB-INF/jsp/question/addquestion.jsp";
            request.getRequestDispatcher(page).forward(request, response);
        }
    }


}
