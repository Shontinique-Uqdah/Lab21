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
			@RequestParam("password1") String password1,
			@RequestParam("password2") String password2,
			@RequestParam("gender") String gender,
			@RequestParam("birthdate") String birthdate) {
		
		String passwordTest;
		
		if (password1.matches(password2)) {
			
			passwordTest = "";
			
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPhoneNum(phoneNum);
			user.setPassword(password1);
			user.setGender(gender);
			user.setBirthdate(birthdate);
			
			ModelAndView mav = new ModelAndView("summary");
			
			//if want to add all details
			//mav.addObject("user", user);
			//Then add ${} to jsp file.
			
			mav.addObject("firstName", firstName);
			return mav;
		}
		
		else {
			passwordTest = "Passwords entered do not match. Please try again.";
			ModelAndView mav = new ModelAndView("registration");
			mav.addObject("firstName", firstName);
			mav.addObject("lastName", lastName);
			mav.addObject("email", email);
			mav.addObject("phoneNum", phoneNum);
			mav.addObject("gender", gender);
			mav.addObject("birthdate", birthdate);
			mav.addObject("passwordTest", passwordTest);
			return mav;
		}
	}
}
