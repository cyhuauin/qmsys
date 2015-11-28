package com.cust.qmsys.servlet.question;

import com.cust.qmsys.service.question.DetailQuestionService;
import com.cust.qmsys.service.question.impl.DetailQuestionServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ? on 2015/10/24.
 */

public class DetailQuestionServlet extends HttpServlet {
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer type = Integer.parseInt(request.getParameter("type"));
        Long qid = Long.parseLong(request.getParameter("qid"));
        String question = "";
        String page = "WEB-INF/jsp/question/detailquestion.jsp";
        DetailQuestionService dqs =new DetailQuestionServiceImpl();
        question = dqs.getQuestion(type,qid);

        response.setCharacterEncoding("utf-8");
        try{
            response.getWriter().print(question);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
//        request.getRequestDispatcher(page).forward(request, response);


    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
