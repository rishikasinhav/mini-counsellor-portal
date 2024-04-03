package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.Entities.EnquiryEntity;
import com.app.Entities.consellorsEntity;
import com.app.dto.Dashboard;
import com.app.service.consellorService;
import com.app.service.enquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class consellorController
{
	@Autowired
	private consellorService c_serv;
	
	@Autowired
	private enquiryService e_serv;
	
	
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req, Model model)
	{
		HttpSession session = req.getSession(false);
		session.invalidate();
		
		return"redirect:/login";
	}
	
	

	@GetMapping("/register")
	public String loadRegister(Model model) {
		
		model.addAttribute("register", new consellorsEntity());
		return"register";
	}
	
	
	
	
	
	@PostMapping("/register")
	public String handleRegisterbtn(consellorsEntity entity, Model model)
	{
		
		
		boolean saveConsellor = c_serv.saveConsellor(entity);
		
		if(saveConsellor==true)
		{
			model.addAttribute("msg", "Register Successful");
			return"register";
		}
		else
		{
			model.addAttribute("emsg","failed to register" );
			return "register";
		}
		
	}
	
	
	
	@GetMapping("/login")
	public String loadLogin(Model model)
	{
		model.addAttribute("consellor", new consellorsEntity());
		
		return "login";
	}
	
	
	
	
	@PostMapping("/login")
	public String handleLoginbtn(HttpServletRequest req, Model model, consellorsEntity consellor) {
		
		consellorsEntity loginConsellor = c_serv.loginConsellor(consellor.getEmail(), consellor.getPassword());
		if(loginConsellor==null)
		{
			model.addAttribute("emsg", "Invalid Credentials");
			return "login";
			
		}
		else
		{
			
			model.addAttribute("msg", "Login Successfull");
			HttpSession session = req.getSession(true);
			session.setAttribute("cid",loginConsellor);
			
			Dashboard dinfo= e_serv.getDashboardInfo(consellor.getConsellorId());
		   model.addAttribute("dashboard", dinfo);
			return"dashboard";
		}
		
	
	}
	
}
