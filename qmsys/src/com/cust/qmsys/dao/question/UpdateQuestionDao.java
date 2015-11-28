package com.cust.qmsys.dao.question;

import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;

/**
 * Created by Դ on 2015/10/28.
 */
public interface UpdateQuestionDao {
public Integer updateChoice(Choice choice);
public Integer updateJudge(Judge judge);
public Integer updateCompletion(Completion compl);
public Integer updateAnswerQuestion(AnswerQuestion aq);

}
