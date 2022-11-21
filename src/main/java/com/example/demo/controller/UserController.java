package com.example.demo.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.User;
import com.example.demo.model.userOperations;

/**
 * Create HelloController for testing the application
 * @author Nacer
 *
 */
@Controller
public class UserController {
	
	userOperations obj = new  userOperations();
	
	@GetMapping({"/","/home"})
    public String hello(Model model) {
        model.addAttribute("name", "Nacer Kraa");
        return "home";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegisterForm() {
		return new ModelAndView("user/registerForm", "user", new User());
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User  user, Model model,HttpSession ses) throws SQLException {
		Map<String, String> messages = new HashMap<String, String>();
		addUserInSession(user,ses);
		boolean res = obj.addUser(user);
		if(res) {
			return "redirect:/";
		}else {
			messages.put("message", "The user is Alredy exist!");
			model.addAttribute("messages", messages);
			return "user/registerForm";
		}
		
	
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginForm() {
        return new ModelAndView("user/loginForm", "user", new User());
    }
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") User  user, Model model,HttpSession ses) throws SQLException {
    
	
	/* for the form validation */
	Map<String, String> messages = new HashMap<String, String>();
	boolean res = obj.authentify(user);
	
	
	if (res) {
		messages.put("message", "You are logged successfully!");
		model.addAttribute("messages", messages);
		User u = obj.getUserByEmail(user.getEmail());
		addUserInSession(u,ses);
		if (u.getType().equals("admin")) {
			return "admin/dashboardAdmin";
		} else {
			return "home";
		}
		
	} else {
		messages.put("message", "The email or the password is not correct!");
		model.addAttribute("errors", messages);
		return "user/loginForm";
	}
    }
	
	
	@RequestMapping("/logout")
	public String showLougout(HttpSession session) throws SQLException {
	    	
	    	session.invalidate() ;
	        return "redirect:/";
	}
	
	public void addUserInSession(User u,HttpSession session){
	   	session.setAttribute("User", u);
	   	session.setAttribute("firstname", u.getFirstName());
	   	session.setAttribute("lastname", u.getLastName());
	   	session.setAttribute("email", u.getEmail());
	}
	
	
    
 }

