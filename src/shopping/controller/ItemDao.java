package shopping.controller;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;

import shopping.bean.Item;

public interface ItemDao {
	Item getItem(int id);
	ArrayList<Item> search(String query, Object[] obj);
	ArrayList<Item> findCriteria(DetachedCriteria criteria);
}
