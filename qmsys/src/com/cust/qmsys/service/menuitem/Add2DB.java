package com.cust.qmsys.service.menuitem;

import com.cust.qmsys.dao.menuitem.impl.MenuitemDaoImpl;
import com.cust.qmsys.domain.Menuitem;

public class Add2DB {
	private static MenuitemDaoImpl dao = new MenuitemDaoImpl();//������ʽ Spring
	//���Ӳ˵�
	public static void add(Menuitem menu) throws MenuitemExistException{
		boolean bool = dao.find(menu.getName());
		if(bool){
			dao.add(menu);//��ӵ�tbl_menuitem����
			dao.addUserItem(menu, menu.getUsers());//��ӵ�user_menuitem����
		}else{
			throw new MenuitemExistException();//����Ҫ��ӵĲ˵��Ѵ��ڣ����web���׳�һ���쳣������web�㣬���û��Ѻ���ʾ
			
		}
	}
	//���²˵�
	public static int query(Menuitem menu){
			return dao.queryMenu(menu);
		}
	//���²˵�
		public static int del(Long mid){
				if(dao.deltbl_menuitem(mid) > 0 && dao.deluser_menuitem(mid) > 0){
					return 1;
				}
				return 0;
		}
}
