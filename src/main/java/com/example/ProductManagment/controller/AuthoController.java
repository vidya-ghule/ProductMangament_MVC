package com.example.ProductManagment.controller;

import java.util.Properties;


import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ProductManagment.Pojo.User;
import com.example.ProductManagment.Pojo.Users;
import com.example.ProductManagment.Service.UserServiceInterface;

@Controller
public class AuthoController {
	@Autowired
	private UserServiceInterface userServiceInterface;
	@Autowired
	private SessionFactory sfg;

	
	@GetMapping(value="/login")
	
	public String login(@ModelAttribute User user,Model model, HttpSession session) {
		System.out.println(user);
		User usr=userServiceInterface.loginuser(user);
		if(usr!=null) {
	            session.setAttribute("username", usr.getUsername());
	            session.setAttribute("userRole", usr.getRole());
	            return "home";
		}
		
		
		model.addAttribute("msg","invalid creditial!!!!");
		return "login";
	}
	
	@GetMapping(value="/forgot")
	public String forgotcont(@ModelAttribute User user,Model model, HttpSession session) {
		
		String trues=userServiceInterface.forgotcont(user,session);
	
		
		
		
		return "login";
		
		
		
	}

		}
	

