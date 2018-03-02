package shopping.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import shopping.bean.CartItem;
import shopping.bean.Item;
import shopping.bean.User;

@Controller
@SessionAttributes({"user","searchResult","size","partResult"})

public class ItemController {

	@Autowired
	private ItemDao ht;
	
	@Autowired
	private UserDao ht2;
	
	public ItemController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/search: category = {category}")  
    public String mainSearch(HttpServletRequest request,Model model,@PathVariable String category){
//		Object keyWord = request.getAttribute("key");
		String query = "from Item where category LIKE ?";
		Object[] obj = {"%"+category+"%"};
		System.out.println(category);
		ArrayList<Item> searchResult= ht.search(query, obj);
		return searchResultProcesser(searchResult,model);
    }
	@RequestMapping(value = "/search")
	public String keySearch(HttpServletRequest request,Model model) {
		String keyWord = request.getParameter("keyWord");
		String query = "from Item where name LIKE ?";
		Object[] obj = {"%"+keyWord+"%"};
		System.out.println(keyWord);
		ArrayList<Item> searchResult= ht.search(query, obj);
		return searchResultProcesser(searchResult,model);
	}
	
	public String searchResultProcesser(ArrayList<Item> searchResult,Model model) {
		model.addAttribute("searchResult",searchResult);
        int total=5;  
        int size = (searchResult.size() -1)/ 5 + 1;
        ArrayList<Item> partResult;
        if(size>1){
        	partResult = new ArrayList<Item>(searchResult.subList(0, 5));
        }  
        else
        	partResult = searchResult;
        model.addAttribute("partResult",partResult);
        model.addAttribute("size",size);  
        model.addAttribute("pageId",1);
//        System.out.println("search"+partResult);
        return "search_result";  
	}
	
	@RequestMapping(value="/search:page = {pageId}")  
    public String noSearch(@PathVariable int pageId,@ModelAttribute ("searchResult") ArrayList<Item> searchResult,
    		Model model){
        int startIndex = (pageId-1)*5;
        int endIndex = Math.min(startIndex + 5,searchResult.size());
        System.out.println(startIndex+""+endIndex);
        ArrayList<Item>	partResult = new ArrayList<Item>(searchResult.subList(startIndex, endIndex));
        model.addAttribute("partResult",partResult);
        model.addAttribute("pageId",pageId);
        return "search_result";  
    }
	@RequestMapping(value="/item_big_id = {index}")
	public String getBigItem(@PathVariable("index") Integer index,Model model,HttpServletRequest request) {
		System.out.println(index);
//		Item item = ((ArrayList<Item>) request.getSession().getAttribute("partResult")).get(index);
//		if(item == null)
		Item item = ht.getItem(index);
		System.out.println(item.getDetail());
//		Item item = ((ArrayList<Item>) request.getSession().getAttribute("partResult")).get(itemId);
		model.addAttribute("item",item);
		model.addAttribute("itemIndex",index);
		return "bigItemView";
	}
	
	@GetMapping(value = "/image = {index}")
	public void showImage(@PathVariable("index") Integer index, HttpServletResponse response,
			  HttpServletRequest request,Model model) 
	          throws ServletException, IOException{
/*		System.out.println(request.getSession().getAttribute("partResult"));
		ArrayList<Item> partResult= (ArrayList<Item>) request.getSession().getAttribute("partResult");
		*/
//	    Item item = ((ArrayList<Item>) request.getSession().getAttribute("partResult")).get(index);
//	    if(item == null)
		Item item = ht.getItem(index);
//	    System.out.println("image"+item.getName());
	    response.setContentType("image/jpeg");
	    response.getOutputStream().write(item.getImage());
	    response.getOutputStream().close();
	}
	
	@RequestMapping(value = "/addItem id = {index}, amount = {amount}")
	public String addItem(@PathVariable("index") Integer index,@PathVariable("amount") Integer amount,
			HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		Item item = ((ArrayList<Item>) session.getAttribute("partResult")).get(index);
		System.out.println(item);
		model.addAttribute("item", item);
		User user = (User) session.getAttribute("user");
//		System.out.println(user);
		int pos = findItemIndex(item,user.getCart());
		if(pos>=0) {
			int innerAmount = user.getCart().get(pos).getAmount();
			user.getCart().get(pos).setAmount(innerAmount+amount);
			if(user.getFirstName() != null) {
//				ht2.saveorupdate(user);
				ht2.update(user);
			}
		}
		else{
			CartItem ci = new CartItem(0,item,amount);
	//		ht.saveItem(ci);
			System.out.println(ci);
			user.getCart().add(ci);
			if(user.getFirstName() != null) {
				ht.saveItem(ci);
				ht2.update(user);
			}
		}
		
//		System.out.println(user);
		return "addItem";
	}
	public int findItemIndex(Item item,List<CartItem> cart) {
		for(int i = 0;i<cart.size();i++) {
			if(item.equals(cart.get(i).getItem()))
				return i;
		}
		return -1;
	}
	
	@RequestMapping(value = "/changeItem id = {index} amount = {amount}")
	@ResponseBody
	public void changeItem(@PathVariable("index") Integer index,@PathVariable("amount") Integer amount,
			HttpServletRequest request,Model model) {
		System.out.println(index +" "+ amount);
		User user = (User) request.getSession().getAttribute("user");
		user.getCart().get(index).setAmount(amount);
		ht.saveUpdateItem(user.getCart().get(index));
		model.addAttribute("user",user);
		
	}
	@RequestMapping(value = "/pre_check_out")
	public String preCheckOut() {
		return "PreCheckOut";
	}
	
	@RequestMapping(value = "/check")
	public String check(Model model,@ModelAttribute("user") User user) {
		List<CartItem> cart = user.getCart();
		model.addAttribute(cart);
		List<CartItem> list = new ArrayList<>();
		user.setCart(list);
		ht2.update(user);
		return "check";
	}
	
	@RequestMapping(value = "/deleteItem id = {index}")
	@ResponseBody
	public void deleteItem(@PathVariable("index") int index,HttpServletRequest request,Model model) {
		User user = (User) request.getSession().getAttribute("user");
		user.getCart().remove(index);
		ht2.update(user);
		model.addAttribute("user",user);
	}

}
