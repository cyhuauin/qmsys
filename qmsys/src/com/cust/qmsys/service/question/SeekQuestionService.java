package com.cust.qmsys.service.question;
import java.util.List;

import com.cust.qmsys.domain.Question;
import com.cust.qmsys.domain.Subject;
public interface SeekQuestionService {
	/**
	 * 
	 * @param type  类型
	 * @param chapter 章节
	 * @param level 难度
	 * @param subject 科目
	 * @return 问题概型集合
	 */
	
	
	
public List<Question> seekQuestion(Integer type,Integer chapter,Integer level,
		Subject subject);

}
