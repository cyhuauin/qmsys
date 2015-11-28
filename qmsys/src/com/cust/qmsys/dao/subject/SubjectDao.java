package com.cust.qmsys.dao.subject;

import java.util.List;
import java.util.Map;

import com.cust.qmsys.domain.Subject;


public interface SubjectDao {
	/**
	 * ���choice������
	 * @param choice
	 * @return Boolean
	 */
public Subject addSubject(String sname);
public List<Map<String, Object>> list();

}
