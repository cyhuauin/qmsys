package com.cust.qmsys.utils;

import com.cust.qmsys.dao.menuitem.impl.MenuitemDaoImpl;

/**
 * 这个类是ZZW用来测试写的dao什么的逻辑是否正确的
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		Long uid = 1l;
		Long mid = 1l;
		MenuitemDaoImpl mdi  = new MenuitemDaoImpl();
		mdi.getChildMenuitemByMid(uid, mid);
	}
}
