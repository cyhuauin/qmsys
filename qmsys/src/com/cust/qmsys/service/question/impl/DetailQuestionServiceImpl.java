package com.cust.qmsys.service.question.impl;

import com.cust.qmsys.dao.question.DetailQuestionDao;
import com.cust.qmsys.dao.question.impl.DetailQuestionDaoImpl;
import com.cust.qmsys.domain.question.AnswerQuestion;
import com.cust.qmsys.domain.question.Choice;
import com.cust.qmsys.domain.question.Completion;
import com.cust.qmsys.domain.question.Judge;
import com.cust.qmsys.service.question.DetailQuestionService;

/**
 * Created by 源 on 2015/10/25.
 */
public class DetailQuestionServiceImpl implements DetailQuestionService{
    DetailQuestionDao dqd = new DetailQuestionDaoImpl();

    @Override
	public String getQuestion(Integer type,Long qid){
        String table = "";
        String view = "";
        switch(type){
            case 1:
                table = "ty_choice";
                Choice ch= new Choice();
                ch = (Choice) dqd.getQuestion(table, qid);
                view = setChoiceView(ch);
                break;
            case 2:
                table = "ty_judge";
                Judge judge = new Judge();
                judge = (Judge)dqd.getQuestion(table,qid);
                view = setJudgeView(judge);
                break;
            case 3:
                table = "ty_completion";
                Completion comp = new Completion();
                comp = (Completion)dqd.getQuestion(table, qid);
                view = setCompletion(comp);
                break;
            case 4:
                table = "ty_anquestion";
                AnswerQuestion anq = new AnswerQuestion();
                anq = (AnswerQuestion)dqd.getQuestion(table,qid);
                view = setAnQuestionView(anq);
                break;
            default:
                break;
        }

        return view;
    }

    public String setChoiceView(Choice choice){

        String table = "<tr><td>题干:<input type='text' id='body' name='body' value='"+choice.getBody()+"'></td></tr>";
        table = table + "<tr><td>A:<input type='text' id='A' name='A' value='"+choice.getA()+"'></td>";
        table = table + "<td>B:<input type='text' name='B' value='"+choice.getB()+"'></td></tr>";
        table = table + "<tr><td>C:<input type='text' name='C' value='"+choice.getC()+"'></td>";
        table = table + "<td>D:<input type='text' name='D' value='"+choice.getD()+"'></td></tr>";
        if (choice.getMulti_Choice() == 1){
            table = table + "<tr><td>E:<input type='text' name='E' value='"+choice.getE()+"'></td>";
            table = table + "<td>F:<input type='text' name='F' value='"+choice.getF()+"'></td></tr>";
        }
        table = table + "<tr><td>答案:<input type='text' name='answer' value='"+choice.getAnswer()+"'></td>";
        table = table + "<td>分数:<input type='text' name='score' value='"+choice.getScore()+"'></td></tr>";
        table = table + "<tr><td>难度:<input type='text' name='level' value='"+choice.getLevel()+"'></td>";
        table = table + "<td>章节:<input type='text' name='chapter' value='"+choice.getChapter()+"'></td></tr>";
        table = table + "<tr><td>图片:<input type='text' id='image' name='image' value='"+choice.getImage()+"'></td></tr>";

        table = table + "<td>创建时间:<input type='text' name='time' value='"+choice.getCreateTime()+"'></td></tr>";
        table = table + "<tr><td>创建人:<input type='text' name='user' value='"+choice.getCreateUser()+"'></td></tr>";
       table = table +"<tr><td><input type='hidden' name = 'type'  id='type' value = '"+choice.getType()+"'></td>";
       table = table +"<td><input type='hidden' name='qid' id='qid' value = '"+choice.getQid()+"'></td></tr>";


        return table;
    }
    public String setJudgeView(Judge judge){
        String table = "<tr><td>题干:<input type='text' name='body' value='"+judge.getBody()+"'></td></tr>";
        
        table = table + "<tr><td>答案:<input type='text' name='answer' value='"+judge.getAnswer()+"'></td>";
        table = table + "<td>分数:<input type='text' name='score' value='"+judge.getScore()+"'></td></tr>";
        table = table + "<tr><td>难度:<input type='text' name='level' value='"+judge.getLevel()+"'></td>";
        table = table + "<td>章节:<input type='text' name='chapter' value='"+judge.getChapter()+"'></td></tr>";
        table = table + "<tr><td>图片:<input type='text' name='image' value='"+judge.getImage()+"'></td>";

        table = table + "<td>创建时间:<input type='text' name='time' value='"+judge.getCreateTime()+"'></td></tr>";
        table = table + "<tr><td>创建人:<input type='text' name='user' value='"+judge.getCreateUser()+"'></td></tr>";
        table = table +"<tr><td><input type='hidden' name = 'type'  id='type' value = '"+judge.getType()+"'></td>";
        table = table +"<td><input type='hidden' name='qid' id='qid' value = '"+judge.getQid()+"'></td></tr>";
        return table;

    }
    public String setCompletion(Completion comp){
        String table = "<tr><td>题干:<input type='text' name='body' value='"+comp.getBody()+"'></td></tr>";

        table = table + "<tr><td>答案:<input type='text' name='answer' value='"+comp.getAnswer()+"'></td>";
        table = table + "<td>分数:<input type='text' name='score' value='"+comp.getScore()+"'></td></tr>";
        table = table + "<tr><td>难度:<input type='text' name='level' value='"+comp.getLevel()+"'></td>";
        table = table + "<td>章节:<input type='text' name='chapter' value='"+comp.getChapter()+"'></td></tr>";
        table = table + "<tr><td>图片:<input type='text' name='image' value='"+comp.getImage()+"'></td>";
        table = table + "<td>创建时间:<input type='text' name='time' value='"+comp.getCreateTime()+"'></td></tr>";
        table = table + "<tr><td>创建人:<input type='text' name='user' value='"+comp.getCreateUser()+"'></td></tr>";
        table = table +"<tr><td><input type='hidden' name = 'type'  id='type' value = '"+comp.getType()+"'></td>";
        table = table +"<td><input type='hidden' name='qid' id='qid' value = '"+comp.getQid()+"'></td></tr>";
        return table;
    }
    public String setAnQuestionView(AnswerQuestion anq){
        String table = "<tr><td>题干:<input type='text' name='body' value='"+anq.getBody()+"'></td></tr>";

        table = table + "<tr><td>答案:<input type='text' name='answer' value='"+anq.getAnswer()+"'></td>";
        table = table + "<td>分数:<input type='text' name='score' value='"+anq.getScore()+"'></td></tr>";
        table = table + "<tr><td>难度:<input type='text' name='level' value='"+anq.getLevel()+"'></td>";
        table = table + "<td>章节:<input type='text' name='chapter' value='"+anq.getChapter()+"'></td></tr>";
        table = table + "<tr><td>图片:<input type='text' name='image' value='"+anq.getImage()+"'></td>";
        table = table + "<td>创建时间:<input type='text' name='time' value='"+anq.getCreateTime()+"'></td></tr>";
        table = table + "<tr><td>创建人:<input type='text' name='user' value='"+anq.getCreateUser()+"'></td></tr>";
        table = table +"<tr><td><input type='hidden' name = 'type'  id='type' value = '"+anq.getType()+"'></td>";
        table = table +"<td><input type='hidden' name='qid' id='qid' value = '"+anq.getQid()+"'></td></tr>";
        return table;
    }
}
