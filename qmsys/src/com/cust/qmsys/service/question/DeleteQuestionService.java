package com.cust.qmsys.service.question;

public interface DeleteQuestionService {
	/**
	 * 
	 * @param qid ��id
	 * @param type ������
	 * @return 1��0 ���
	 */
    public Integer delQuestion(Long qid,Integer type);

}
