package com.cust.qmsys.service.question.impl;

import com.cust.qmsys.dao.question.AddQuestionDao;
import com.cust.qmsys.dao.question.impl.AddQuestionDaoImpl;
import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;
import com.cust.qmsys.service.question.AddQuestionService;

/**
 * 传值相应的类型题目信息
 */
public class AddQuestionServiceImpl implements AddQuestionService {

    AddQuestionDao add = new AddQuestionDaoImpl();

    @Override
	public Boolean addChoice(Choice choice, Integer type) {

        Choice ch;

        ch = add.addChoice(choice);
        if (ch != null)
            return true;
        else
            return false;
    }

    @Override
    public Boolean addJudge(Judge judge, Integer type) {
        Judge jud;
        jud = add.addJudge(judge);
        if (jud != null)
            return true;
        else
            return false;
    }

    @Override
    public Boolean addCompletion(Completion cmpl, Integer type) {
        Completion com;
        com = add.addCompletion(cmpl);
        if (com != null)
            return true;
        else
            return false;
    }

    @Override
    public Boolean addAnswerQuestion(AnswerQuestion anq, Integer type) {
        AnswerQuestion an;
        an = add.addAnswerQuestion(anq);
        if (an != null)
            return true;
        else
            return null;
    }


}
