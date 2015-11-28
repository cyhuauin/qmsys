package com.cust.qmsys.service.question;

import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;

public interface AddQuestionService{
	/**
	 * �������
	 * @param choice �� ����������Ϣ
	 * @param type ����
	 * @return bool 
	 */
public Boolean addChoice(Choice choice,Integer type);
public Boolean addJudge(Judge judge,Integer type);
public Boolean addCompletion(Completion cmpl,Integer type);
public Boolean addAnswerQuestion(AnswerQuestion anq,Integer type);

}
