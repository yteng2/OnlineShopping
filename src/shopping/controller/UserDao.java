package shopping.controller;

import shopping.bean.User;

public abstract class UserDao {

	
	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	abstract boolean save(User user);
	abstract void update(User user);
	abstract User get(String userName,String password);

}
