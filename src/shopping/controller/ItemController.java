package shopping.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import shopping.bean.Item;

@Controller
@SessionAttributes({"user","searchResult","size"})

public class ItemController {

	@Autowired
	private ItemDao ht;
	
	public ItemController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/search:{category}")  
    public String mainSearch(HttpServletRequest request,Model model,@PathVariable String category){
//		Object keyWord = request.getAttribute("key");
		String query = "from Item where category LIKE ?";
		Object[] obj = {"%"+category+"%"};
		System.out.println(category);
		ArrayList<Item> searchResult= ht.search(query, obj);
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
	@RequestMapping(value="/item_big_id = {itemId}")
	public String getBigItem(@PathVariable("itemId") Integer itemId,Model model,HttpServletRequest request) {
		System.out.println(itemId);
		Item item = ht.getItem(itemId);
		System.out.println(item);
//		Item item = ((ArrayList<Item>) request.getSession().getAttribute("partResult")).get(itemId);
		model.addAttribute("item",item);
//		model.addAttribute("itemIndex",itemId);
		return "bigItemView";
	}
	
	@GetMapping(value = "/image = {itemId}")
	  public void showImage(@PathVariable("itemId") Integer itemIndex, HttpServletResponse response,
			  HttpServletRequest request,Model model) 
	          throws ServletException, IOException{
/*		System.out.println(request.getSession().getAttribute("partResult"));
		ArrayList<Item> partResult= (ArrayList<Item>) request.getSession().getAttribute("partResult");
		*/
	    Item item = ht.getItem(itemIndex);
	    
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(item.getImage());
	    response.getOutputStream().close();
	}

}
