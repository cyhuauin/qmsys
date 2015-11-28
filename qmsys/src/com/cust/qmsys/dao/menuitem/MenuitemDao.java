package com.cust.qmsys.dao.menuitem;

import java.util.List;

import com.cust.qmsys.domain.Menuitem;

public interface MenuitemDao {
	/**
	 * 获取所有的菜单id
	 * @return 菜单id的集合
	 */
	public List<Long> getAllMid();

	/**
	 * 获取所有菜单对象
	 * @return 菜单项集合
	 */
	public List<Menuitem> getAllMenuitem();

	/**
	 * 获取该用户的所有菜单项
	 * @return 菜单项集合
	 */
	public List<Menuitem> getMenuitemByUid(Long uid);

	/**
	 * 根据uid获取所有的父级菜单项 
	 * @param uid
	 * @return
	 */
	public List<Menuitem> getParentMenuitemByUid(Long uid);
	
	/**
	 * 根据父菜单的id和uid，获取权限下的所有子菜单项
	 * @param uid
	 * @param mid
	 * @return 子菜单集合
	 */
	public List<Menuitem> getChildMenuitemByMid(Long uid,Long mid);
	/**
	 * 根据父菜单的id，获取权限下的所有子菜单项
	 * @param uid
	 * @param mid
	 * @return 子菜单集合
	 */
	List<Menuitem> getChildMenuitemByMid(Long mid);
}
