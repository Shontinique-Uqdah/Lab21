package co.grandcircus.parlor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView showHomePageLoggedIn(@RequestParam(value="category", required=false) String category,
			@PathVariable("type") String type, @ModelAttribute("user") User user) {
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
	public ModelAndView showLoginForm(@PathVariable("type") String type, @ModelAttribute("fail") String fail) {
		ModelAndView mav = new ModelAndView("login-form");
		mav.addObject("type", type);
		
		if (!fail.equals("")) {
			mav.addObject("fail", fail);
		}
		return mav;
	}
	
	//RedirectAttributes allows me to send data from one controller to another when I redirect, so I can redirect and keep user info
	//Addflash attribute enables me to do so without showing the info in the clientside url
	@RequestMapping("/verify-login/{type}")
	public ModelAndView verifyLogin(@PathVariable("type") String type, 
			@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redir) {
		
		User user;
		try {
		 user = parlorDao.findByEmail(email);
		}
		
		catch(Exception ex) {
			user = null;
		}
		
		String fail = "";
		ModelAndView mav = null;
		
		if (type.equals("admin")) {
			
			if (user != null) {
				
				if (user.isAdmin() && password.matches(user.getPassword())) {
					mav = new ModelAndView("redirect:/logged-in/admin");
					redir.addFlashAttribute("user", user);
				}
				
				else if (user.isAdmin() && !password.matches(user.getPassword())){
					fail = "Sorry, that password does not match any administrators in our records. Please try again.";
					mav = new ModelAndView("redirect:/login-form/admin");
					redir.addAttribute("fail", fail);
					redir.addAttribute("email", email);
					}
				
			}
			
			else {
				fail = "Sorry, there is no admin associated with that email address.";
				mav = new ModelAndView("redirect/login-form/admin");
				mav.addObject("fail", fail);
			}
		}
		
		else if (type.equals("member")) {
			
			if (user != null) {
				
				if (!user.isAdmin() && password.matches(user.getPassword())) {
					mav = new ModelAndView("redirect:/logged-in/member");
					redir.addFlashAttribute("user", user);
				}
				
				else {
					fail = "Sorry, that password does not match our records. Please try again.";
					mav = new ModelAndView("redirect:/login-form/member");
					redir.addAttribute("fail", fail);
					redir.addAttribute("email", email);
				}
			}
			
			else {
				
				fail = "Sorry, there is no member associated with that email address.";
				mav = new ModelAndView("redirect:/login-form/member");
				redir.addAttribute("fail", fail);
			}
		}
		
		
			
		return mav;
	}
	
}
