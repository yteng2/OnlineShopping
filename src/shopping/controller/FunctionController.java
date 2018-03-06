package shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class FunctionController {

/*	@ExceptionHandler(Exception.class)
	public String displayError(Exception exception, Model model,HttpServletRequest request){
		System.out.println("this is excetion handler method");
		model.addAttribute("exception", exception.getMessage());
		model.addAttribute("url", request.getRequestURI());
		return "errorPage";
	}*/
	
//	@ExceptionHandler(value = Exception.class)
	public ModelAndView displayError(Exception exception, Model model,HttpServletRequest request)throws Exception{
		System.out.println("this is excetion handler method");
		ModelAndView mv= new ModelAndView();
		mv.addObject("exception", exception.getMessage());
		mv.addObject("url", request.getRequestURI());
		mv.setViewName("errorPage");
		return mv;
	}


}
