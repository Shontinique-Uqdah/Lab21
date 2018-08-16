package co.grandcircus.parlor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IceCreamParlorController {
	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		
		String greeting = "Welcome to ScoopZ Ice-Cream Parlor!";
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("greeting", greeting);
		return mav;
	}
	
	@RequestMapping("/registration")
	public ModelAndView showRegistration() {
		ModelAndView mav = new ModelAndView("registration");
		return mav;
	}
	
	@RequestMapping("/summary")
	public ModelAndView showSummary(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email,
			@RequestParam("phoneNum") String phoneNum,
			@RequestParam("password") String password,
			@RequestParam("user") String user) {
		
		ModelAndView mav = new ModelAndView("summary");
		
		mav.addObject("firstName", firstName);
		return mav;
	}
}
