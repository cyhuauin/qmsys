package com.cust.qmsys.dao.paper;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.cust.qmsys.domain.Paper;

public class Test {
	public static void main(String [] args) throws ClassNotFoundException, SQLException{
		Paper paper = new Paper();
		paper.setPaperNum("01002");
		paper.setGrade("���꼶");
		paper.setSubject("����");
		paper.setScore(100);
		paper.setTeacher("��ʦ");
		paper.setDate(new Date());
		AddPaper ad = new AddPaper();
		//ad.addPaper(paper);
		
		DelPaper de = new DelPaper();
		//de.delPaper(paper);
		
		QueryPaper query = new QueryPaper();
		System.out.println("hdeh");
		List<Paper> list = query.query();
		System.out.println(list.size());
		for(int i = 0;i < list.size();i++){
			System.out.println(list.get(i).getPaperNum()+" "+list.get(i).getGrade());
		}
	}

}
