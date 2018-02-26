package shopping.controller;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping.bean.Item;

@Service
public class ItemDaoHT implements ItemDao {
	
	@Autowired
	HibernateTemplate ht;
	
	public ItemDaoHT() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getItem(int id) {
		// TODO Auto-generated method stub
		return ht.get(Item.class, id);
	}

	@Override
	@Transactional
	public ArrayList<Item> search(String query,Object[] obj) {
		return (ArrayList<Item>) ht.find(query, obj);
	}
	
	@Override
	@Transactional
	public ArrayList<Item> findCriteria(DetachedCriteria criteria){
		return (ArrayList<Item>) ht.findByCriteria(criteria);
	}

}
