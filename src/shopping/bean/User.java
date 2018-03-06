package shopping.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "shopping_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@NotBlank
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,15}$", message = "you password must contain at lease"
			+ "one lower case letter, one higher case letter and one number. you password must longer than 4 and short than 15.")
	String password;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]+$", message = "first name can only contain letters")
	String firstName;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]+$", message = "lase name can only contain letters")
	String lastName;

	@NotBlank
	@Email
//	@Pattern(regexp = "[\\w-]+@([\\w-]+\\.)+[\\w-]+", message = "this should be a email address, you have to follow this pattern: xxx@xxx.xxx")
	String email;
	
	@Pattern(regexp = "[0-9]+{10}", message = "phone number can only contain numbers and must have 10 digit")
	String phone;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	Address address;
	
	@OneToMany
	@JoinColumn(name = "user_id")
	List<CartItem> cart;
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
	
	public User(int id, String password, String firstName, String lastName, String email, String phone, Address address,
			List<CartItem> cart) {
		super();
		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.cart = cart;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User(int id, String password, String firstName, String lastName, String email, String phone,
			List<CartItem> cart) {
		super();
		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.cart = cart;
	}

	public List<CartItem> getCart() {
		return cart;
	}

	public void setCart(List<CartItem> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", cart=" + cart + "]";
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
