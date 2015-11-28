package com.cust.qmsys.dao.question;

import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;

public interface AddQuestionDao {
    /**
     * ���choice������
     *
     * @param choice
     * @return Boolean
     */
    public Choice addChoice(Choice choice);

    public Judge addJudge(Judge judge);

    public Completion addCompletion(Completion cmp);

    public AnswerQuestion addAnswerQuestion(AnswerQuestion anq);
}
