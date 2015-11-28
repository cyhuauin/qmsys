package com.cust.qmsys.service.user.impl;

import java.util.List;

import com.cust.qmsys.dao.menuitem.MenuitemDao;
import com.cust.qmsys.dao.menuitem.impl.MenuitemDaoImpl;
import com.cust.qmsys.dao.user.UserDao;
import com.cust.qmsys.dao.user.impl.UserDaoImpl;
import com.cust.qmsys.domain.Menuitem;
import com.cust.qmsys.domain.User;
import com.cust.qmsys.service.user.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao = null;
	private MenuitemDao menuitemDao =null;
	@Override
	public User userLogin(String username) {
		userDao = new UserDaoImpl();
		User user = userDao.query(username);
        System.out.println(user.getPassword());
		if(null != user){//查有此人
			menuitemDao = new MenuitemDaoImpl();
			List<Menuitem> menuitems = menuitemDao.getParentMenuitemByUid(user.getUid());//获取权限下的父级菜单项
			for(Menuitem parentMenu:menuitems){
				parentMenu.setChildrens(menuitemDao.getChildMenuitemByMid(user.getUid(), parentMenu.getMid()));
			}
			user.setMenuitems(menuitems);

		}
		return user;
	}
	
}
