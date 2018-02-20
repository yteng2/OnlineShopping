package shopping.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column
	String password;
	@Column
	String firstName;
	@Column
	String lastName;
	@Column
	String email;
	@Column
	String phone;
	@OrderColumn
	@ElementCollection
	List<Integer> cart;
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String password, String firstName, String lastName, String email, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public User(int id, String password, String firstName, String lastName, String email, String phone,
			ArrayList<Integer> cart) {
		super();
		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.cart = cart;
	}

	public List<Integer> getCart() {
		return cart;
	}

	public void setCart(List<Integer> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", cart=" + cart + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
