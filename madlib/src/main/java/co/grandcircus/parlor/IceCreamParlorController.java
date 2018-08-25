package co.grandcircus.parlor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.parlor.dao.IceCreamDao;
import co.grandcircus.parlor.dao.ParlorDao;

@Controller
public class IceCreamParlorController {
	
	
	@Autowired
	private ParlorDao parlorDao;
	
	@Autowired
	private IceCreamDao iceCreamDao;
	
	@RequestMapping("/")
	public ModelAndView showHomePage(@RequestParam(value="category", required=false) String category) {
		List<IceCream> iceCreams = iceCreamDao.findAll();
		List<IceCream> iceCreamsByCategory = iceCreamDao.findByCategory(category);
		
//		Maybe request param and use email to state user name?
//		User user = parlorDao.findByEmail(email);
		
		String greeting = "Welcome to ScoopZ Ice-Cream Parlor!";
			ModelAndView mav = new ModelAndView("index");
			mav.addObject("greeting", greeting);
		
		
		if (category != null && !category.isEmpty()) {
			mav.addObject("iceCreams", iceCreamsByCategory);
			mav.addObject("category", category);
		} else {
			mav.addObject("iceCreams", iceCreams);
		}
		
		return mav;
	}
	
	@RequestMapping("/logged-in/{type}")
	public ModelAndView showHomePage(@RequestParam(value="category", required=false) String category,
			@PathVariable("type") String type, @RequestParam("user") User user) {
		List<IceCream> iceCreams = iceCreamDao.findAll();
		List<IceCream> iceCreamsByCategory = iceCreamDao.findByCategory(category);
		
//		Maybe request param and use email to state user name?
//		User user = parlorDao.findByEmail(email);
		
		String greeting;
		
		if (type.equals("admin")) {
			greeting = "Administrator View";
		}
		else {
			greeting = "Welcome back to ScoopZ " + user.getFirstName() + "!";
		}
			ModelAndView mav = new ModelAndView("index");
			mav.addObject("greeting", greeting);
			mav.addObject("type", type);
		
		
		if (category != null && !category.isEmpty()) {
			mav.addObject("iceCreams", iceCreamsByCategory);
			mav.addObject("category", category);
		} else {
			mav.addObject("iceCreams", iceCreams);
		}
		
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
			user.setAdmin(false);
			
			parlorDao.create(user);
			
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
	
	//Allows to specify whether a user or admin is logging in, using same form
	@RequestMapping("/login-form/{type}")
	public ModelAndView showLoginForm(@PathVariable("type") String type) {
		ModelAndView mav = new ModelAndView("login-form");
		mav.addObject("type", type);
		return mav;
	}
	
	
	@RequestMapping("/verify-login/{type}")
	public ModelAndView verifyLogin(@RequestParam("email") String email, 
			@RequestParam("password") String password,
			@PathVariable("type") String type) {
		
		User user = parlorDao.findByEmail(email);
		
		String loginFailed;
		ModelAndView mav;
		
		if (user != null) {
			if (user.isAdmin() && password.matches(user.getPassword())) {
				mav = new ModelAndView("/logged-in/admin?user=user");
			}
			else if (user.isAdmin() && !password.matches(user.getPassword())){
			loginFailed = "Sorry, that password does not match any administrators in our records. Please try again.";
			mav = new ModelAndView("redirect:/login-form/admin");
			mav.addObject("loginFailed", loginFailed);
			mav.addObject("email", email);
			}
			else if (password.matches(user.getPassword())) {
			mav = new ModelAndView("/logged-in/member/user=user");			}
			else {
				loginFailed = "Sorry, that password does not match our records. Please try again.";
				mav = new ModelAndView("redirect:/login-form/member");
				mav.addObject("loginFailed", loginFailed);
				mav.addObject("email", email);
			}
		}
		
		else {
			if (type.equals("admin")) {
				loginFailed = "Sorry, there is no admin associated with that email address.";
				mav = new ModelAndView("redirect:/login-form/admin");
				mav.addObject("loginFailed", loginFailed);
			}
			else {
				loginFailed = "Sorry, there is no member associated with that email address.";
				mav = new ModelAndView("redirect:/login-form/member");
				mav.addObject("loginFailed", loginFailed);
			}
		
		}
		return mav;
	}
	
}
