package com.cust.qmsys.servlet.question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import com.cust.qmsys.domain.Question;
import com.cust.qmsys.domain.Subject;
import com.cust.qmsys.service.question.SeekQuestionService;
import com.cust.qmsys.service.question.impl.SeekQuestionServiceImpl;

/**
 * Servlet implementation class SeekQuestionServlet
 */
public class SeekQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeekQuestionServlet() {
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
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	Integer type = 1;
	Integer level = 1;
	Integer chapter = 1;
	Subject sub = null;
	List<Question> li = new ArrayList<Question>();
	if(request.getParameter("type")!=null){
		type = Integer.parseInt(request.getParameter("type"));
	}
	if(request.getParameter("level")!=null){
		level = Integer.parseInt(request.getParameter("level"));
	}
	if(request.getParameter("chapter")!=null){
		chapter = Integer.parseInt(request.getParameter("chapter"));
	}

	SeekQuestionService sqs = new SeekQuestionServiceImpl();
	 li = sqs.seekQuestion(type, chapter, level, sub);
        List chapterli = new ArrayList();
        List levelli = new ArrayList();
        for (int i=1;i<li.size();i++){
            if (li.get(i).getChapter()!=li.get(i-1).getChapter()){

            }
        }
	JSONArray json = new JSONArray();
	json.addAll(li);
	json.listIterator();
	
	if(json.isEmpty()){
		System.out.println("kong");
	}
    try {
		response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
	} catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}
   
	}
}
