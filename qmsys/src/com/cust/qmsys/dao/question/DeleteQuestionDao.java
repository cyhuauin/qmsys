package com.cust.qmsys.dao.question;

public interface DeleteQuestionDao {
	/**
	 * 
	 * @param qid ���id
	 * @param table ���ݿ����
	 * @return
	 */
    public	boolean DelQuestion(long qid,String table);
}
