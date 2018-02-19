package shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {

	public Controller1() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/")
	String getHeader() {
		return "header";
	}

}
