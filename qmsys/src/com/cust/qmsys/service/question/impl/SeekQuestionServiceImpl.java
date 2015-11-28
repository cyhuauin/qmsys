package com.cust.qmsys.service.question.impl;

import com.cust.qmsys.dao.question.SeekQuestionDao;
import com.cust.qmsys.dao.question.impl.SeekQuestionDaoImpl;
import com.cust.qmsys.domain.Question;
import com.cust.qmsys.domain.Subject;
import com.cust.qmsys.service.question.SeekQuestionService;

import java.util.ArrayList;
import java.util.List;

public class SeekQuestionServiceImpl implements SeekQuestionService{

	@Override
	public List<Question> seekQuestion(Integer type, Integer chapter,
			Integer level, Subject subject) {
//		String subname = subject.getSname();
		String subname = "";

 		List<Question> li = new ArrayList<Question>();
		System.out.println(chapter+"service"+level);

			SeekQuestionDao sqd = new SeekQuestionDaoImpl();
			li = sqd.seekQuestion(type, chapter, level,subname);
			for (Question ch : li) {
				System.out.println(ch+"    "+ch.getQid()+ch.getBody()+ch.getLevel());

		}
		
		return li;
	}

}
