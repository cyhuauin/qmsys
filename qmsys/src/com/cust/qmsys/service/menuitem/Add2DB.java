package com.cust.qmsys.service.menuitem;

import com.cust.qmsys.dao.menuitem.impl.MenuitemDaoImpl;
import com.cust.qmsys.domain.Menuitem;

public class Add2DB {
	private static MenuitemDaoImpl dao = new MenuitemDaoImpl();//工厂格式 Spring
	//增加菜单
	public static void add(Menuitem menu) throws MenuitemExistException{
		boolean bool = dao.find(menu.getName());
		if(bool){
			dao.add(menu);//添加到tbl_menuitem表中
			dao.addUserItem(menu, menu.getUsers());//添加到user_menuitem表中
		}else{
			throw new MenuitemExistException();//发现要添加的菜单已存在，则给web层抛出一个异常，提醒web层，给用户友好提示
			
		}
	}
	//更新菜单
	public static int query(Menuitem menu){
			return dao.queryMenu(menu);
		}
	//更新菜单
		public static int del(Long mid){
				if(dao.deltbl_menuitem(mid) > 0 && dao.deluser_menuitem(mid) > 0){
					return 1;
				}
				return 0;
		}
}
