package com.example.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
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
public class HelloController {
	
	userOperations obj = new  userOperations();
	
	@GetMapping({"/","/home"})
    public String hello(Model model) {
        model.addAttribute("name", "Nacer Kraa");
        return "home";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("user/userForm", "user", new User());
    }
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") User  user, Model model,HttpSession ses) throws SQLException {
    
	/* for the form validation */
	Map<String, String> messages = new HashMap<String, String>();
	User u = obj.getUserByEmail(user.getEmail());
	boolean res = obj.authentify(user);
	addUserInSession(u,ses);
	
	if (res) {
		messages.put("message", "You are logged successfully!");
		model.addAttribute("messages", messages);
		if (u.getType().equals("admin")) {
			return "dashboardAdmin";
		} else {
			return "home";
		}
		
	} else {
		messages.put("message", "The email or the password is not correct!");
		model.addAttribute("errors", messages);
		return "user/userForm";
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

