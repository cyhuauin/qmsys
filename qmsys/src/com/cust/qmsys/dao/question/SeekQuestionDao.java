package com.cust.qmsys.dao.question;

import java.util.List;

public interface SeekQuestionDao {

    /**
     *
     * @param chapter �½�
     * @param level   �Ѷ�
     * @param subname �γ�����
     * @return choice����
     */
    public  List seekQuestion(Integer type,Integer chapter,Integer level,String subname);

}
