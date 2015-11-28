package com.cust.qmsys.domain;

import java.util.List;

public class Menuitem {
	private Long mid;
	private int isparent;
	private String name;
	private String url;
	private String icon;
	private Long parentid;

	private List<User> users;
	private List<Menuitem> childrens;

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public int getIsparent() {
		return isparent;
	}

	public void setIsparent(int isparent) {
		this.isparent = isparent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Menuitem> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Menuitem> childrens) {
		this.childrens = childrens;
	}

	@Override
	public String toString() {
		return "Menuitem [mid=" + mid + ", isparent=" + isparent + ", name="
				+ name + ", url=" + url + ", icon=" + icon + ", parentid="
				+ parentid + ", users=" + users + "]";
	}

}
