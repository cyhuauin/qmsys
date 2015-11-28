package com.cust.qmsys.service.question;

public interface DeleteQuestionService {
	/**
	 * 
	 * @param qid 题id
	 * @param type 题类型
	 * @return 1或0 真假
	 */
    public Integer delQuestion(Long qid,Integer type);

}
