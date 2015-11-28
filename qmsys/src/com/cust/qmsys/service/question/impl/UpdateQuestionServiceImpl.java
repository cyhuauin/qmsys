package com.cust.qmsys.service.question.impl;

import com.cust.qmsys.dao.question.UpdateQuestionDao;
import com.cust.qmsys.dao.question.impl.UpdateQuestionDaoImpl;
import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;
import com.cust.qmsys.service.question.UpdateQuestionService;

/**
 * Created by Դ on 2015/10/27.
 */
public class UpdateQuestionServiceImpl implements UpdateQuestionService {
    UpdateQuestionDao uqd = new UpdateQuestionDaoImpl();
    @Override
    public boolean updateChoice(Choice choice) {

        Integer up = uqd.updateChoice(choice);
        if (up == 1)
         return true;

        return false;
    }

    @Override
    public boolean updateJudge(Judge judge) {

        Integer up = uqd.updateJudge(judge);
        if (up == 1)
            return true;

        return false;
    }

    @Override
    public boolean updateCompletion(Completion compl) {
        Integer up = uqd.updateCompletion(compl);
        if (up == 1)
            return true;

        return false;
    }

    @Override
    public boolean updateAnswerQuestion(AnswerQuestion anq) {
        Integer up = uqd.updateAnswerQuestion(anq);
        if (up == 1)
            return true;

        return false;
    }
}
