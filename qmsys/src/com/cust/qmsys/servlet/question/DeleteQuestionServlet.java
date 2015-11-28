package com.cust.qmsys.servlet.question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.service.question.DeleteQuestionService;
import com.cust.qmsys.service.question.impl.DeleteQuestionServiceImpl;

import java.io.IOException;

/**
 * Created by cy2015/10/23.
 */

public class DeleteQuestionServlet extends HttpServlet {
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer type = 0;
        Long qid = (long) 0;
        String jieguo;
        qid = (long) Integer.parseInt(request.getParameter("id"));
        type = Integer.parseInt(request.getParameter("type"));
        DeleteQuestionService dqs  = new DeleteQuestionServiceImpl();
        Integer result = dqs.delQuestion(qid, type);
       if(result == 1){
           jieguo = "success";
       } else{
           jieguo = "error";
       }

    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
