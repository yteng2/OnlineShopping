package shopping.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Shopping_item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column
	String name;
	@Column
	Double price;
	@Column
	int stock;
	@Column
	String category;
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Item(int id, String name, Double price, int stock, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", category=" + category
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
