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
		// �˵�������Ϊ��
		if (this.name == null || this.name.trim().equals("")) {
			isOk = false;
			map.put("name", "�˵�������Ϊ�գ�����");
		}
		if(this.isparent == 0){//������ӽڵ�Ļ������ڵ��Ų���Ϊ��
			if(this.parentid == null || (String.valueOf(this.parentid)).trim().equals("") || this.parentid == 0){
				isOk = false;
				map.put("parentid", "���ڵ㲻��Ϊ�գ�����");
			}
			if(!mdi.find(this.parentid)){
				isOk = false;
				map.put("parentid", "���ڵ㲻���ڣ�����");
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
	//�޸ĺ�ı���֤
	public boolean validate2() {
		boolean isOk = true;
		MenuitemDaoImpl mdi = new MenuitemDaoImpl();
		// �˵�������Ϊ��
		if (this.name == null || this.name.trim().equals("")) {
			isOk = false;
			map.put("name", "�˵�������Ϊ�գ�����");
		}
		if(this.isparent == 1){//����Ǹ��ڵ�
			if(this.parentid != 0){
				isOk = false;
				map.put("parentid", "���ڵ����Ϊ0������");
			}
			
		}else{//�ӽڵ�
			if(this.parentid == null || (String.valueOf(this.parentid)).trim().equals("")){
				isOk = false;
				map.put("parentid", "���ڵ㲻��Ϊ�գ�����");
			}
			if(!mdi.find(this.parentid)){
				isOk = false;
				map.put("parentid", "�˽ڵ㲻���ڣ�����");//���ڵ㲻����
			}
		}
		this.users = mdi.getAllUser();
		this.childrens = mdi.getChildMenuitemByMid(mid);
		return isOk;
	}

}
