package com.cust.qmsys.service.question;

import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;

public interface AddQuestionService{
	/**
	 * 插入操作
	 * @param choice 类 该题所有信息
	 * @param type 类型
	 * @return bool 
	 */
public Boolean addChoice(Choice choice,Integer type);
public Boolean addJudge(Judge judge,Integer type);
public Boolean addCompletion(Completion cmpl,Integer type);
public Boolean addAnswerQuestion(AnswerQuestion anq,Integer type);

}
