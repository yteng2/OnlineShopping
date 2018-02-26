package shopping.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@OneToOne
	@JoinColumn(name = "item_id")
	Item item;
	int amount;
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	public CartItem(int id, Item item, int amount) {
		super();
		this.id = id;
		this.item = item;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", item=" + item + ", amount=" + amount + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
