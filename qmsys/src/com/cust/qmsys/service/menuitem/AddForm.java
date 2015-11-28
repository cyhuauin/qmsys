package com.cust.qmsys.service.menuitem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cust.qmsys.dao.menuitem.impl.MenuitemDaoImpl;
import com.cust.qmsys.domain.Menuitem;
import com.cust.qmsys.domain.User;

public class AddForm {
	private Long mid;
	private int isparent;
	private String name;
	private String url;
	private String icon;
	private Long parentid;
	private List<User> users;
	private List<Menuitem> childrens;
	
	private Map<String,String> map = new HashMap<String,String>();
	
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

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

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

	public boolean validate() {
		boolean isOk = true;
		MenuitemDaoImpl mdi = new MenuitemDaoImpl();
		// 菜单名不能为空
		if (this.name == null || this.name.trim().equals("")) {
			isOk = false;
			map.put("name", "菜单名不能为空！！！");
		}
		if(this.isparent == 0){//如果是子节点的话，父节点编号不能为空
			if(this.parentid == null || (String.valueOf(this.parentid)).trim().equals("") || this.parentid == 0){
				isOk = false;
				map.put("parentid", "父节点不能为空！！！");
			}
			if(!mdi.find(this.parentid)){
				isOk = false;
				map.put("parentid", "父节点不存在！！！");
			}
		}
		long id = mdi.getMenuitemMaxId();
		this.icon = "";
		this.url = "";
		this.mid = ++id;
		this.users = mdi.getAllUser();
		this.childrens = mdi.getChildMenuitemByMid(mid);
		return isOk;
	}
	//修改后的表验证
	public boolean validate2() {
		boolean isOk = true;
		MenuitemDaoImpl mdi = new MenuitemDaoImpl();
		// 菜单名不能为空
		if (this.name == null || this.name.trim().equals("")) {
			isOk = false;
			map.put("name", "菜单名不能为空！！！");
		}
		if(this.isparent == 1){//如果是父节点
			if(this.parentid != 0){
				isOk = false;
				map.put("parentid", "父节点必须为0！！！");
			}
			
		}else{//子节点
			if(this.parentid == null || (String.valueOf(this.parentid)).trim().equals("")){
				isOk = false;
				map.put("parentid", "父节点不能为空！！！");
			}
			if(!mdi.find(this.parentid)){
				isOk = false;
				map.put("parentid", "此节点不存在！！！");//父节点不存在
			}
		}
		this.users = mdi.getAllUser();
		this.childrens = mdi.getChildMenuitemByMid(mid);
		return isOk;
	}

}
