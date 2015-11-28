package com.cust.qmsys.dao.menuitem.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cust.qmsys.dao.menuitem.MenuitemDao;
import com.cust.qmsys.domain.Menuitem;
import com.cust.qmsys.domain.User;
import com.cust.qmsys.utils.JDBCConnection;

public class MenuitemDaoImpl implements MenuitemDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	static Statement stmt = null;// ������ --ǫ��

	@Override
	public List<Long> getAllMid() {
		String sql = "SELECT mid FROM tbl_menuitem";
		List<Long> mids = new ArrayList<Long>();
		try {
			conn = JDBCConnection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Long mid = rs.getLong("mid");
				mids.add(mid);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}
		return mids;
	}

	@Override
	public List<Menuitem> getAllMenuitem() {
		String sql = "SELECT * FROM tbl_menuitem";
		List<Menuitem> menuitems = new ArrayList<Menuitem>();
		try {
			conn = JDBCConnection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Menuitem menuitem = new Menuitem();
				menuitem.setMid(rs.getLong("mid"));
				menuitem.setIsparent(rs.getInt("isparent"));
				menuitem.setName(rs.getString("name"));
				menuitem.setUrl(rs.getString("url"));
				menuitem.setIcon(rs.getString("icon"));
				menuitem.setParentid(rs.getLong("parentid"));
				// System.out.println(menuitem.toString());
				menuitems.add(menuitem);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}
		return menuitems;
	}

	@Override
	public List<Menuitem> getParentMenuitemByUid(Long uid) {
		String sql = "SELECT tbl_menuitem.* FROM user_menuitem "
				+ "LEFT JOIN tbl_menuitem ON user_menuitem.mid = tbl_menuitem.mid "
				+ "WHERE user_menuitem.uid = ? AND parentid = 0";
		List<Menuitem> menuitems = new ArrayList<Menuitem>();
		try {
			conn = JDBCConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Menuitem menuitem = new Menuitem();
				menuitem.setMid(rs.getLong("mid"));
				menuitem.setIsparent(rs.getInt("isparent"));
				menuitem.setName(rs.getString("name"));
				menuitem.setUrl(rs.getString("url"));
				menuitem.setIcon(rs.getString("icon"));
				menuitem.setParentid(rs.getLong("parentid"));
				System.out.println(menuitem.toString());
				menuitems.add(menuitem);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}
		return menuitems;
	}

	@Override
	public List<Menuitem> getMenuitemByUid(Long uid) {
		// TODO ����uid��ȡȫ���Ĳ˵���
		return null;
	}

	// ����mid��uid��ȡ���е��ӽڵ�
	@Override
	public List<Menuitem> getChildMenuitemByMid(Long uid, Long mid) {
		String sql = "SELECT tbl_menuitem.* FROM user_menuitem "
				+ "LEFT JOIN tbl_menuitem ON user_menuitem.mid = tbl_menuitem.mid "
				+ "WHERE user_menuitem.uid = ? AND parentid = ?";
		List<Menuitem> menuitems = new ArrayList<Menuitem>();
		try {
			conn = JDBCConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, uid);
			ps.setLong(2, mid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Menuitem menuitem = new Menuitem();
				menuitem.setMid(rs.getLong("mid"));
				menuitem.setIsparent(rs.getInt("isparent"));
				menuitem.setName(rs.getString("name"));
				menuitem.setUrl(rs.getString("url"));
				menuitem.setIcon(rs.getString("icon"));
				menuitem.setParentid(rs.getLong("parentid"));
				System.out.println(menuitem.toString());
				menuitems.add(menuitem);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}
		return menuitems;
	}

	// �����Ƿ�Ϊ���ڵ�:�Ƿ���true ���Ƿ���false---------------------------------ǫ��
	public boolean isParent(Long mid) {
		boolean isOk = false;
		String sql = "SELECT * FROM tbl_menuitem where isparent = 1";
		try {
			conn = JDBCConnection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (mid.equals(rs.getLong("mid"))) {
					isOk = true;
					break;
				}

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}
		return isOk;
	}

	// ��ȡ����mid --------------------------------------------ǫ��
	public Long getMenuitemMaxId() {
		String sql = "SELECT MAX(MID) AS id FROM tbl_menuitem";
		try {
			conn = JDBCConnection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return Long.parseLong(rs.getString("id"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���������ʧ��");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}
		return (long) 0;
	}

	// �鿴menuitem�����Ƿ��Ѵ��� -----------------------------------------ǫ��
	public boolean find(String name) {
		boolean isOk = true;
		List<Menuitem> list = getAllMenuitem();
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getName())) {
				isOk = false;
				break;
			}
		}
		return isOk;
	}

	// ���鸸�ڵ��Ƿ����,���ڷ���true -----------------------------------------ǫ��
	public boolean find(long parentid) {
		boolean isOk = false;
		List<Menuitem> list = getParentMenuitemByUid((long) 1);// ����uid =
																// 1;//�ɸĳ����е�uid
		for (int i = 0; i < list.size(); i++) {
			if (parentid == list.get(i).getMid() || parentid == 0) {
				isOk = true;
				break;
			}
		}
		return isOk;
	}

	// �������ݿ�tbl_menuitem------------------------------ǫ��
	public int add(Menuitem menu) {
		// INSERT INTO tbl_menuitem VALUES(67,0,"","ddd",7,"");
		String sql = "insert into tbl_menuitem values(" + menu.getMid() + "," + menu.getIsparent() + "" + ",'"
				+ menu.getIcon() + "','" + menu.getName() + "'," + menu.getParentid() + ",'" + menu.getUrl() + "');";
		try {
			stmt = JDBCConnection.getConnection().createStatement();
			return stmt.executeUpdate(sql);// ���²�����
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ����ʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���ݿ����ʧ��");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
			JDBCConnection.close(stmt);
		}
		return 0;
	}

	// ����� user_menuitem------------------------------ǫ��
	public int addUserItem(Menuitem menu, List<User> list) {
		// INSERT INTO user_menuitem VALUES(1,67);
		for (int i = 0; i < list.size(); i++) {
			String sql = "INSERT INTO user_menuitem VALUES(" + list.get(i).getUid() + "," + menu.getMid() + ");";
			try {
				stmt = JDBCConnection.getConnection().createStatement();
				return stmt.executeUpdate(sql);// ���²�����
			} catch (ClassNotFoundException e) {
				System.out.println("���ݿ����ʧ��");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("���ݿ����ʧ��");
				e.printStackTrace();
			} finally {
				JDBCConnection.close(rs);
				JDBCConnection.close(ps);
				JDBCConnection.close(conn);
				JDBCConnection.close(stmt);
			}
		}

		return 0;
	}

	// ��ȡ���е��û� ----------------------------------------ǫ��
	public List<User> getAllUser() {
		String sql = "SELECT * FROM tbl_user";
		List<User> users = new ArrayList<User>();
		try {
			conn = JDBCConnection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setUid(rs.getLong("uid"));
				u.setName(rs.getString("name"));
				u.setUsername(rs.getString("username"));
				u.setPassword("password");
				u.setIsleader(rs.getInt("isleader"));
				u.setPhone(rs.getString("phone"));
				u.setEmail(rs.getString("email"));
				users.add(u);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}
		return users;
	}

	// ����mid��ȡ���е��ӽڵ� ----------------------------------ǫ��
	@Override
	public List<Menuitem> getChildMenuitemByMid(Long mid) {
		// SELECT * FROM tbl_menuitem WHERE parentid = 2
		String sql = "SELECT * FROM tbl_menuitem WHERE parentid = " + mid;
		List<Menuitem> menuitems = new ArrayList<Menuitem>();
		try {
			conn = JDBCConnection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Menuitem menuitem = new Menuitem();
				menuitem.setMid(rs.getLong("mid"));
				menuitem.setIsparent(rs.getInt("isparent"));
				menuitem.setName(rs.getString("name"));
				menuitem.setUrl(rs.getString("url"));
				menuitem.setIcon(rs.getString("icon"));
				menuitem.setParentid(rs.getLong("parentid"));
				System.out.println(menuitem.toString());
				menuitems.add(menuitem);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
		}
		return menuitems;
	}

	// ����toString������ȡmenu����
	public Menuitem getMenuBytoString(String str) {
		// String str = "Menuitem [mid=70, isparent=0, name=ŶŶŶ, url=, icon=,
		// parentid=69, users=null]";
		Menuitem menu = new Menuitem();
		String[] arr = str.split(",");
		for (int i = 0; i < arr.length; i++) {
			int index = arr[i].indexOf("=");
			arr[i] = arr[i].substring(index + 1, arr[i].length());
		}
		menu.setMid(Long.parseLong(arr[0]));
		menu.setIsparent(Integer.parseInt(arr[1]));
		menu.setName(arr[2]);
		menu.setUrl(arr[3]);
		menu.setIcon(arr[4]);
		menu.setParentid(Long.parseLong(arr[5]));
		menu.setUsers(null);
		return menu;
	}

	// �޸�menu��
	public int queryMenu(Menuitem menu) {
		String sql = "UPDATE tbl_menuitem SET NAME = '" + menu.getName() + "',url = '" + menu.getUrl() + "',icon = '"
				+ menu.getIcon() + "',parentid = " + menu.getParentid() + "  WHERE MID = " + menu.getMid() + " ;";
		try {
			stmt = JDBCConnection.getConnection().createStatement();
			int a = stmt.executeUpdate(sql);
			System.out.println("--------------" + a);
			return a;// ���²�����
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ��");
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			System.out.println("���ݸ���ʧ��");
			e.printStackTrace();
			return 0;
		} finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
			JDBCConnection.close(stmt);
		}
	}

	// ɾ��user_menuitem------------------------------ǫ��
	public int deluser_menuitem(Long mid) {
		// delete from user_menuitem where mid = menu.getMid();
		String sql = "delete from user_menuitem where mid = " + mid + ";";
		try {
			stmt = JDBCConnection.getConnection().createStatement();
			return stmt.executeUpdate(sql);// ���²�����
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ����ʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���ݿ����ʧ��");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs);
			JDBCConnection.close(ps);
			JDBCConnection.close(conn);
			JDBCConnection.close(stmt);
		}

		return 0;
	}
	// ɾ��tbl_menuitem------------------------------ǫ��
		public int deltbl_menuitem(Long mid) {
			// delete from user_menuitem where mid = menu.getMid();
			String sql = "delete from tbl_menuitem where mid = " + mid + ";";
			try {
				stmt = JDBCConnection.getConnection().createStatement();
				return stmt.executeUpdate(sql);// ���²�����
			} catch (ClassNotFoundException e) {
				System.out.println("���ݿ����ʧ��");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("���ݿ����ʧ��");
				e.printStackTrace();
			} finally {
				JDBCConnection.close(rs);
				JDBCConnection.close(ps);
				JDBCConnection.close(conn);
				JDBCConnection.close(stmt);
			}

			return 0;
		}
}
