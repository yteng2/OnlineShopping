package shopping.controller;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;

import shopping.bean.Address;
import shopping.bean.Item;
import shopping.bean.User;

public interface UserDao {

	
	abstract boolean save(User user);
	abstract void update(User user);
	abstract User get(String userName,String password);
	abstract void saveorupdate(User user);
	abstract boolean checkEmail(String email);
	abstract void saveOrUpdate(Address address);
	//ArrayList<Item> getCart(ArrayList<Integer> id);


}
