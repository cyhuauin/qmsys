package com.cust.qmsys.domain;

import java.util.List;

public class User {
	private Long uid;
	private String username;
	private String name;
	private String password;
	private String usex;
	private String phone;
	private String email;
	private Integer isleader;
	private List<Subject> subjects;
	private List<Menuitem> menuitems;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
  public String getName(){
	  return name;
  }
  public void setName(String name) {
	this.name = name;
}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	 public String getUsex(){
	    	return usex;
	    }
     public void setUsex(String usex){
	    	this.usex = usex;
	    }
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(String string, List<Subject> subjects) {
		this.subjects = subjects;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIsleader() {
		return isleader;
	}
   public void setIsleader(Integer isleader){
	   this.isleader = isleader;
   }
   public List<Menuitem> getMenuitems() {
		return menuitems;
	}

	public void setMenuitems(List<Menuitem> menuitems) {
		this.menuitems = menuitems;
	}

	

	

	
}
	
