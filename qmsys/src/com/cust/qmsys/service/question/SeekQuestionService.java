package com.cust.qmsys.service.question;
import java.util.List;

import com.cust.qmsys.domain.Question;
import com.cust.qmsys.domain.Subject;
public interface SeekQuestionService {
	/**
	 * 
	 * @param type  ����
	 * @param chapter �½�
	 * @param level �Ѷ�
	 * @param subject ��Ŀ
	 * @return ������ͼ���
	 */
	
	
	
public List<Question> seekQuestion(Integer type,Integer chapter,Integer level,
		Subject subject);

}
