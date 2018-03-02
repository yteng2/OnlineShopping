package shopping.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import shopping.bean.CartItem;
import shopping.bean.Item;
import shopping.bean.User;

@Controller
@SessionAttributes({"user","categories","searchResult"})
@PropertySource(value="/resources/config_en.properties")
public class UserController {
	@Autowired
	private UserDao ht;
	@Autowired
	private ItemDao itemht;
	
	@Value("#{'${item.category}'.split(',')}")
	String[]  categories ;
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	@RequestMapping(value = "/language")
	public ModelAndView language(Locale locale, Model model,HttpServletRequest request) {
		String url = request.getHeader("referer");
//		System.out.println(url);
		String[] temp = url.split("/");
		temp[temp.length-1] = temp[temp.length-1].replaceAll("%20", " ");
//		System.out.println(temp[temp.length-1]);
		if(temp[temp.length-1].equals("OnlineShopping"))
			temp[temp.length-1] = "";
		return new ModelAndView("redirect:/"+temp[temp.length-1]);
	}
	
	@RequestMapping(value = "/go_back")
	public String goBack(HttpServletRequest request) {
		String url = request.getHeader("referer");
		String[] urlArray = url.split("/");
		url = urlArray[urlArray.length-1];
		url = URLDecoder.decode(url);
		System.out.println("hh"+url);
		return "redirect:/" +url;
	}
	
	@RequestMapping(value = "/")
	public String home() {
		return "Home";
	}
	
	@RequestMapping(value = "/check_email")
	@ResponseBody
	public String checkEmail(@RequestBody String search) {
		search = URLDecoder.decode(search);
		search = search.replaceAll("=", "");
//		System.out.println(search);

		Boolean valid = ht.checkEmail(search);
		String jsonResult = new Gson().toJson(valid);
//		System.out.println(jsonResult);
		return jsonResult;
	}
	
	@RequestMapping("/header")
	String header(Model model,HttpServletRequest request) {
//		System.out.println( categories [0]);
		model.addAttribute( "categories",categories );
		if(request.getSession().getAttribute("user") == null) {
			User user = new User();
			List<CartItem> cart = new ArrayList<>();
			user.setCart(cart);
			model.addAttribute("user", user);
		}
		return "header";
	}
	@PostMapping("/login")
	String getHeader(HttpServletRequest request,@ModelAttribute("user") User user,Model model) {
		User realUser = ht.get(user.getEmail(), user.getPassword());
		System.out.println(realUser);
		if(realUser == null) {
			model.addAttribute("failed","failed");
			return "Login_Register";
		}
//		request.getSession().setAttribute("user", user);		
//		realUser.getCart().addAll(user.getCart());  // update real user's cart, combine temp user's cart to real user
		combine(realUser.getCart(),user.getCart());
		saveCartEntity(realUser);    // save new CartItem to db;update old CartItem;
		ht.update(realUser);
		model.addAttribute("user", realUser);
		System.out.println("during loging"+request.getSession().getAttribute("user"));
		System.out.println(user.getEmail());
		return "Home";
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
		return "Home";
		
	}
	//method save or update cartItem list
	private void saveCartEntity(User user) {
		List<CartItem> list = user.getCart();
		for(int i = 0;i<list.size();i++) {
			itemht.saveUpdateItem(list.get(i));
		}
	}
	// method combine two cartItem list, same item will be combine with amount;
	private void combine(List<CartItem> l1,List<CartItem> l2){
		int length = l1.size();
		for(int i = 0;i<l2.size();i++) {
			Boolean flag = false;
			for(int j = 0;j<length;j++) {
				if(l1.get(j).getItem().equals(l2.get(i).getItem())) {
					l1.get(j).setAmount(l1.get(j).getAmount()+l2.get(i).getAmount());
					flag = true;
				}
			}
			if(flag == false) {
				l1.add(l2.get(i));
			}	
		}
	}
	
	@RequestMapping("/login_register")
	String getLogin(Model model) {
//		model.addAttribute("user",new User());
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
	public String logOut(SessionStatus st,Model model) {
		System.out.println("this is logging out");
		st.setComplete();
		User user = new User();
		List<CartItem> cart = new ArrayList<>();
		user.setCart(cart);
		System.out.println(user);
		model.addAttribute("user", user);
		//System.out.println(model.get("user"));
		//request.getSession().invalidate();
		return "Home";
	}
	
	@PostMapping("/updatePassword")
	public String updatePassword(HttpServletRequest request,@RequestParam("piCurrPass") String curPassword) {
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user == null);
		System.out.println(request.getParameter("piCurrPass"));
		System.out.println(curPassword);
		if(!request.getParameter("piCurrPass").equals(user.getPassword())) {
			return "/";
		}
		else {
			user.setPassword((String) request.getParameter("piNewPass"));
			ht.update(user);
			return "Home";
		}
		
	}
	
	@RequestMapping("/preUpdatePassword")
	public String preUpdatePassword() {
		return "changePassword";
	}
	
	
	
	


}
