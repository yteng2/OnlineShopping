package shopping.controller;

import java.util.ArrayList;

import org.springframework.orm.hibernate5.HibernateTemplate;

import shopping.bean.User;

public class UserDaoHT extends UserDao {
	HibernateTemplate ht = new HibernateTemplate();
	public UserDaoHT() {
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean save(User user) {
		return ht.save(user) != null;
	}

	@Override
	void update(User user) {
		ht.update(user);
	}

	@Override
	User get(String userName, String password) {
		// TODO Auto-generated method stub
		Object[] values = {userName,password};
		String query = "select * from shopping_user where email = ? and password = ?"; 
		ArrayList<User> result= (ArrayList<User>) ht.find(query, values);
		if(result.isEmpty())
			return null;
		return result.get(0);
	}

}
