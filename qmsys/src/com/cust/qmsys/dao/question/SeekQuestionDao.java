package com.cust.qmsys.dao.question;

import java.util.List;

public interface SeekQuestionDao {

    /**
     *
     * @param chapter 章节
     * @param level   难度
     * @param subname 课程名称
     * @return choice集合
     */
    public  List seekQuestion(Integer type,Integer chapter,Integer level,String subname);

}
