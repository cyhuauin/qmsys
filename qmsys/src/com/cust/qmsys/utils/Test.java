package com.cust.qmsys.utils;

import com.cust.qmsys.dao.menuitem.impl.MenuitemDaoImpl;

/**
 * �������ZZW��������д��daoʲô���߼��Ƿ���ȷ��
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
