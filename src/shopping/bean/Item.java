package shopping.bean;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	
	@Column(length = 4000)
	String detail;
	
    @Lob
    @Column(name="ITEM_IMAGE", nullable=false)
    private byte[] image;
    
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Item(int id, String name, Double price, int stock, String category, String detail) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category = category;
		this.detail = detail;
	}
	public Item(int id, String name, Double price, int stock, String category, String detail, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category = category;
		this.detail = detail;
		this.image = image;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Item(int id, String name, Double price, int stock, String category, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category = category;
		this.image = image;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
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
				+ ", image=" + Arrays.toString(image) + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + stock;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
			return false;
		if (id != other.id)
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (stock != other.stock)
			return false;
		return true;
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
