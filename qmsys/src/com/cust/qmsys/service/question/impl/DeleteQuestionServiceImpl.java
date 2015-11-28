package com.cust.qmsys.service.question.impl;

import com.cust.qmsys.dao.question.DeleteQuestionDao;
import com.cust.qmsys.dao.question.impl.DeleteQuestionDaoImpl;
import com.cust.qmsys.service.question.DeleteQuestionService;

public class DeleteQuestionServiceImpl implements DeleteQuestionService{

	

	@Override
	public Integer delQuestion(Long qid, Integer type) {
		// TODO Auto-generated method stub
		String table = "";
		switch(type){
	 	    case 1:
			    table = "ty_choice";
			    break;
            case 2:
                table = "ty_judge";
                break;
            case 3:
                table = "ty_completion";
                break;
            case 4:
                table = "ty_anquestion";
                break;
		    default:
		  	    break;
		}
		DeleteQuestionDao dqd = new DeleteQuestionDaoImpl();
		Boolean result = dqd.DelQuestion(qid, table);
		if(result == true){
			return 1;
		}
		return 0;
		
		
		
	}

}
