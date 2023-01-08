package com.example.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.dao.Service;
import com.example.demo.model.ServiceOperation;



@Controller
public class ServiceController {
	ServiceOperation obj = new  ServiceOperation();
	
	@RequestMapping("/listServices")   
    public String showDataCommande(@ModelAttribute("service") Service service,Model m) throws SQLException {
    	
    	ArrayList<Service> listService = obj.viewAll();
    	
        m.addAttribute("services",listService);
        return "service/listServices";
}
	
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
	
	@RequestMapping(value="/deleteService/{idService}",method = RequestMethod.GET)
	public String  deleteProduct(@PathVariable("idService") int idService ){
		obj.deleteService(idService);
		return "redirect:/listServices";
	}
	
	@RequestMapping(value="/editService/{id}")
    public String edit(@PathVariable String id, Model m) throws SQLException{
    	
    	Service service = obj.getServiceById(id);
    	System.out.println(service.getTitle());
        m.addAttribute("service" , service);
        return "/service/editService";
    }
}
