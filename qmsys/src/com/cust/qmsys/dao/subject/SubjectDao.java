package com.cust.qmsys.dao.subject;

import java.util.List;
import java.util.Map;

import com.cust.qmsys.domain.Subject;


public interface SubjectDao {
	/**
	 * 添加choice类型题
	 * @param choice
	 * @return Boolean
	 */
public Subject addSubject(String sname);
public List<Map<String, Object>> list();

}
