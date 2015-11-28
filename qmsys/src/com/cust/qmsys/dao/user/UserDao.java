package com.cust.qmsys.dao.user;
	import com.cust.qmsys.domain.User;

	public interface UserDao {
		
		public User query(String username);
		public int insert(User user);
		public  int delete(String uid);
		public  int update(User user);
	}
	//уе╨у