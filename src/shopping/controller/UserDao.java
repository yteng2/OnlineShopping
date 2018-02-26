package shopping.controller;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;

import shopping.bean.Item;
import shopping.bean.User;

public interface UserDao {

	
	abstract boolean save(User user);
	abstract void update(User user);
	abstract User get(String userName,String password);
	//ArrayList<Item> getCart(ArrayList<Integer> id);


}
