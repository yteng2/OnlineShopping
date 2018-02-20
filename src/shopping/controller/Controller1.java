package shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import shopping.bean.Item;
import shopping.bean.User;

@Controller
@SessionAttributes({"user","categories"})
@PropertySource(value="/resources/config.properties")
public class Controller1 {
	@Autowired
	private UserDao ht;
	
	@Value("#{'${item.category}'.split(',')}")
	String[]  categories ;
	
	public Controller1() {
		// TODO Auto-generated constructor stub
	}
	
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
	@RequestMapping("/")
	String header(Model model) {
		System.out.println( categories [0]);
		model.addAttribute( categories );
		return "header";
	}
	@GetMapping("/login")
	String getHeader(@ModelAttribute("user") User user) {
		user = ht.get(user.getEmail(), user.getPassword());
		if(user == null) {
			return "login";
		}
		return "header";
	}
	@PostMapping("/register")
	String postHeader(@ModelAttribute ("user") User user) {
/*		user.setEmail(request.getParameter("email"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(request.getParameter("phone"));*/
		System.out.println(user);
		System.out.println(ht.save(user));
		return "header";
	}
	
	@RequestMapping("/login_register")
	String getLogin(Model model) {
		model.addAttribute("user",new User());
		return "Login_Register";
	}
	
	@RequestMapping("/cart")
	public String getCart(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<Integer> list;
		if(user == null || user.getCart() == null)
			list = new ArrayList<Integer>();
		else
			list = (ArrayList<Integer>) user.getCart();
		ArrayList<Item> cart = ht.getCart(list);
		return "Shopping_Cart";
	}


}
