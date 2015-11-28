package com.cust.qmsys.service.subject.impl;

import com.cust.qmsys.dao.subject.SubjectDao;

import com.cust.qmsys.dao.subject.impl.SubjectDaoImpl;

import com.cust.qmsys.service.subject.SubjectService;

import java.util.List;
import java.util.Map;

public class SubjectServiceImpl implements SubjectService {

	@Override
	public int addSubject(String sname) {
		
		return 0;
	}

    @Override
    public List<Map<String,Object>> FindallSubject() {
        SubjectDao sd = new SubjectDaoImpl();
        List<Map<String, Object>> sub = sd.list();

        return sub;
    }

}
