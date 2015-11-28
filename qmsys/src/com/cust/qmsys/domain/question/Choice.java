package com.cust.qmsys.domain.question;

import java.util.Date;

import com.cust.qmsys.domain.Subject;
import com.cust.qmsys.domain.User;

public class Choice {
	/**
	 * 选择题（包含单选、多选）
	 */
  private  Long qid;
  private  Integer type;
  private  String  body;
  private  String  a;
  private  String  b;
  private  String  c;
  private  String  d;
  private  String  e;
  private  String  f;
  private  String  answer;
  private  Double  score;
  private  Integer level;
  private  Integer chapter;
  private  String  image;
  private  Integer multi_choice;
  private  Date create_time;
  private  User createuser;
  private  Subject subject;
  private  Integer usetime;
  public   Long getQid(){
	  return qid;
  }
  public  void setQid(Long qid){
	  this.qid = qid;
  }
  public  Integer  getType(){
	  return type;
  }	
  public  void  setType(Integer type){
	  this.type = type;
  }
  public  String  getBody(){
	  return body;
  }
  public  void setBody(String body){
	  this.body = body;
  }
  public  String getA(){
	  return a;
  }
  public  void  setA(String a){
	  this.a = a;
  }
  public  String getB(){
	  return b;
  }
  public  void  setB(String b){
	  this.b = b;
  }
  public  String getC(){
	  return c;
  }
  public  void  setC(String c){
	  this.c = c;
  }
  public  String getD(){
	  return d;
  }
  public  void  setD(String d){
	  this.d = d;
  }
  public  String getE(){
	  return e;
  }
  public  void  setE(String e){
	  this.e = e;
  }
  public  String getF(){
	  return f;
  }
  public  void  setF(String f){
	  this.f = f;
  }
  public  String getAnswer(){
	  return answer;
  }
  public  void  setAnswer(String answer){
	  this.answer = answer;
  }
  public Double getScore(){
	  return score;
  }   
  public void setScore(Double score){
	  this.score = score;
  }
  public Integer getLevel(){
	  return level;
  }
  public void setLevel(Integer level){
	  this.level = level;
  }
  public Integer getChapter(){
	  return chapter;
  }
  public void setChapter(Integer chapter){
	  this.chapter = chapter;
  }
  public  String getImage(){
	  return image;
  }
  public  void  setImage(String image){
	  this.image = image;
  }
  public  Integer getMulti_Choice(){
	  return multi_choice;
  }
  public  void  setMulti_Choice(Integer  multi_choice){
	  this.multi_choice = multi_choice;
  }
  public Date getCreateTime(){
	  return create_time;
  }
  public void setCreateTime(Date create_time){
	  this.create_time = create_time;
  }
  public  User getCreateUser(){
	  return createuser;
  }
  public  void  setCreateUser(User createuser){
	  this.createuser = createuser;
  } 
  public  Subject getSubject(){
	  return subject;
  }
  public  void  setSubject(Subject subject){
	  this.subject = subject;
  } 
  public   Integer getUsetime(){
	  return usetime;
  }
  public  void setUsetime(Integer usetime){
	  this.usetime = usetime;
  }
}
