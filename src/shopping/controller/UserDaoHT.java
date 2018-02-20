package shopping.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import shopping.bean.Item;
import shopping.bean.User;
@Repository
public class UserDaoHT implements UserDao {
	@Autowired
	HibernateTemplate ht = new HibernateTemplate();
	public UserDaoHT() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean save(User user) {
		System.out.println("this is ht save method:" + user);
		return ht.save(user) != null;
	}

	@Override
	public void update(User user) {
		ht.update(user);
	}

	@Override
	public User get(String userName, String password) {
		// TODO Auto-generated method stub
		Object[] values = {userName,password};
		String query = "from shopping_user where email = ? and password = ?"; 
		ArrayList<User> result= (ArrayList<User>) ht.find(query, values);
		if(result.isEmpty())
			return null;
		return result.get(0);
	}

	@Override
	public ArrayList<Item> getCart(ArrayList<Integer> id) {
		String cartId = id.toString();
		System.out.println(cartId);
		cartId = cartId.replaceAll("\\[","{");
		cartId = cartId.replaceAll("\\]","}");
		System.out.println(cartId);
		String query = "select * from shopping_item where id in ?";
		Object[] obj = {cartId};
		return (ArrayList<Item>) ht.find(query, obj);
	}

}
