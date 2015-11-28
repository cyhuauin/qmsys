package com.cust.qmsys.service.subject;

import java.util.List;
import java.util.Map;

public interface SubjectService {
	public int addSubject(String sname);
    public List<Map<String,Object>> FindallSubject();
}
