package shopping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import shopping.bean.CartItem;
import shopping.bean.Item;
import shopping.bean.User;

@Controller
@SessionAttributes({"user","categories","searchResult"})
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
	
	@RequestMapping("/header")
	String header(Model model) {
//		System.out.println( categories [0]);
		model.addAttribute( "categories",categories );
		model.addAttribute("cart", new ArrayList<CartItem>());
		return "header";
	}
	@PostMapping("/login")
	String getHeader(HttpServletRequest request,@ModelAttribute("user") User user,Model model,
			@ModelAttribute("cart") List<CartItem> cart) {
		user = ht.get(user.getEmail(), user.getPassword());
		System.out.println(user);
		if(user == null) {
			return "login_register";
		}
//		request.getSession().setAttribute("user", user);
		model.addAttribute("user", user);
		user.getCart().addAll(cart);
		cart = user.getCart();
		System.out.println("during loging"+request.getSession().getAttribute("user"));
		System.out.println(user.getEmail());
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
	public String getCart(HttpServletRequest request,Model model) {
		User user = (User) request.getSession().getAttribute("user");
		List<CartItem> list;
		if(user == null || user.getCart() == null)
			list = new ArrayList<CartItem>();
		else
			list = user.getCart();
/*		String cartId = list.toString();
		System.out.println(cartId);
		cartId = cartId.replaceAll("\\[","");
		cartId = cartId.replaceAll("\\]","");*/
		System.out.println(list);
//		list.add(1);
/*		Object[] obj = {list};
		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		criteria.add(Restrictions.in("id", list));
		try{
			ArrayList<Item> cart = ht.findCriteria(criteria);
		}catch(Exception e) {
			System.out.println("during "e);
		}*/
//		ArrayList<Item> cart = ht.search("",);
		model.addAttribute("cart",list);
		return "Shopping_Cart";
	}
	@RequestMapping("/logOut")
	public String logOut(SessionStatus st) {
		System.out.println("this is logging out");
		st.setComplete();
		//model.remove("user");
		//System.out.println(model.get("user"));
		//request.getSession().invalidate();
		return "header";
	}
	
	
	
	


}
