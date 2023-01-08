package com.example.demo.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.Service;
import com.example.demo.dao.User;
import com.example.demo.model.ServiceOperation;
import com.example.demo.model.userOperations;

@Controller
public class ServiceController {
	ServiceOperation obj = new  ServiceOperation();
	@RequestMapping(value = "/addService", method = RequestMethod.GET)
    public ModelAndView showRegisterForm() {
		return new ModelAndView("service/registerServiceForm", "service", new Service());
    }
	
	@RequestMapping(value = "/addService", method = RequestMethod.POST)
    public String register(@ModelAttribute("service") Service  service, Model model,HttpSession ses) throws SQLException {
		boolean res = obj.addService(service);
		if(res) {
			return "redirect:/";
		}else {
			
			return "hello";
		}
    }
}
