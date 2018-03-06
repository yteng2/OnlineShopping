package shopping.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shopping_address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@NotBlank
	String add1;
	String add2;
	
	@NotBlank
	String city;
	@NotBlank
	String state;
	
	@NotNull
	int post;
	@NotBlank
	String country;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String add1, String add2, String city, String state, int post, String country) {
		super();
		this.id = id;
		this.add1 = add1;
		this.add2 = add2;
		this.city = city;
		this.state = state;
		this.post = post;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", add1=" + add1 + ", add2=" + add2 + ", city=" + city + ", state=" + state
				+ ", post=" + post + ", country=" + country + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
