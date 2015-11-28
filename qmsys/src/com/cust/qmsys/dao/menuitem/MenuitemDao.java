package com.cust.qmsys.dao.menuitem;

import java.util.List;

import com.cust.qmsys.domain.Menuitem;

public interface MenuitemDao {
	/**
	 * ��ȡ���еĲ˵�id
	 * @return �˵�id�ļ���
	 */
	public List<Long> getAllMid();

	/**
	 * ��ȡ���в˵�����
	 * @return �˵����
	 */
	public List<Menuitem> getAllMenuitem();

	/**
	 * ��ȡ���û������в˵���
	 * @return �˵����
	 */
	public List<Menuitem> getMenuitemByUid(Long uid);

	/**
	 * ����uid��ȡ���еĸ����˵��� 
	 * @param uid
	 * @return
	 */
	public List<Menuitem> getParentMenuitemByUid(Long uid);
	
	/**
	 * ���ݸ��˵���id��uid����ȡȨ���µ������Ӳ˵���
	 * @param uid
	 * @param mid
	 * @return �Ӳ˵�����
	 */
	public List<Menuitem> getChildMenuitemByMid(Long uid,Long mid);
	/**
	 * ���ݸ��˵���id����ȡȨ���µ������Ӳ˵���
	 * @param uid
	 * @param mid
	 * @return �Ӳ˵�����
	 */
	List<Menuitem> getChildMenuitemByMid(Long mid);
}
