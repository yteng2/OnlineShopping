package shopping.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import shopping.bean.Item;
import shopping.bean.User;

@Service
public class UserDaoHT implements UserDao {
	@Autowired
	HibernateTemplate ht;
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
	@Transactional
	public void update(User user) {
		ht.update(user);
	}
	
	
	@Override
	@Transactional
	public User get(String userName, String password) {
		// TODO Auto-generated method stub
		Object[] values = {userName,password};
		String query = "from User where email = ? and password = ?"; 
		ArrayList<User> result= (ArrayList<User>) ht.find(query, values);
		if(result.isEmpty())
			return null;
		return result.get(0);
	}

	@Override
	@Transactional
	public void saveorupdate(User user) {
		ht.saveOrUpdate(user);
		
	}

	@Override
	public boolean checkEmail(String email) {
		String query = "from User where email = ?";
		boolean result = ht.find(query, email).isEmpty();
		return result;
	}


	

}
