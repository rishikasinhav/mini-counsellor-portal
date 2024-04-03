package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.Entities.EnquiryEntity;

import com.app.service.consellorService;
import com.app.service.enquiryService;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class enquiryController {
	
	@Autowired
	private consellorService c_Serv;
	
	@Autowired
	private enquiryService e_Serv;
	
	@GetMapping("/addenquiry")
	public String LoadAddEnquiry(Model model, HttpServletRequest req)
	{
		
		HttpSession session = req.getSession(false);
		session.getAttribute("cid");
		model.addAttribute("enquiry", new EnquiryEntity());

		return"addEnquiryView";
	}
	
	@PostMapping("/addenquiry")
	public String handleSaveBtn(Model model, HttpServletRequest req,EnquiryEntity enquiry)
	{
		HttpSession session = req.getSession(false);
		Integer cid = (Integer)session.getAttribute("cid");
		
		boolean b = e_Serv.addEnquiry(enquiry, cid);
		
		if(b)
		{
			model.addAttribute("msg", "enquiry Saved");
			return"addEnquiryView";
		}
		else
		{
			model.addAttribute("emsg", "equiry not saved");
			
			return"addEnquiryView";
		}
	
	}
	
	@GetMapping("/viewEnquires")
	public String viewEnquiriesPage(HttpServletRequest req,Model model)
	{

		HttpSession session = req.getSession(false);
		Integer cid = (Integer)session.getAttribute("cid");
		
		List<EnquiryEntity> list = e_Serv.getEnquiries(new EnquiryEntity(), cid);
		model.addAttribute("enq", list);
		
		model.addAttribute("enq",new EnquiryEntity());
		
		
		return"viewEnquiries";
	}
	
	public String filterEnquiry(HttpServletRequest req, Model model,EnquiryEntity enq)
	{

		HttpSession session = req.getSession(false);
		Integer cid = (Integer)session.getAttribute("cid");
		
		List<EnquiryEntity> enquiries = e_Serv.getEnquiries(enq, cid);
		model.addAttribute("enq",enquiries);
		
		return"viewEnquiries";
	}
	
	@GetMapping("/edit")
	public String editEnquiry(@RequestParam("enqId")EnquiryEntity enqId, Model model)
	{
		EnquiryEntity enquiry = e_Serv.getEnquiry(enqId);
		
		model.addAttribute("enqs",enquiry);
	return"viewEnquiries";	
	}
}
