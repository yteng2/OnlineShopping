package shopping.controller;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;

import shopping.bean.CartItem;
import shopping.bean.Item;

public interface ItemDao {
	Item getItem(int id);
	void saveItem(CartItem ci);
	ArrayList<Item> search(String query, Object[] obj);
	ArrayList<Item> findCriteria(DetachedCriteria criteria);
	void saveUpdateItem(CartItem ci);
}
