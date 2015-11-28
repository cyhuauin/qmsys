package com.cust.qmsys.service.question;

import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;

/**
 * choice 更新的题所有信息
 * return 真假
 * Created by Դ on 2015/10/27.
 */
public interface UpdateQuestionService {
    public boolean updateChoice(Choice choice);
    public boolean updateJudge(Judge judge);
    public boolean updateCompletion(Completion compl);
    public boolean updateAnswerQuestion(AnswerQuestion anq);
}
