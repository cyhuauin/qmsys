package com.cust.qmsys.dao.question;

public interface DeleteQuestionDao {
	/**
	 * 
	 * @param qid 题的id
	 * @param table 数据库表名
	 * @return
	 */
    public	boolean DelQuestion(long qid,String table);
}
