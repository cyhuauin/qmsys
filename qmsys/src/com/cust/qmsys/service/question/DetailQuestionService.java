package com.cust.qmsys.service.question;

/**
 * type 题型
 * qid id
 * return 返回题的具体信息
 * Created by 源 on 2015/10/25.
 */
public interface DetailQuestionService {
    public String getQuestion(Integer type,Long qid);
}
