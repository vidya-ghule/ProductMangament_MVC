package com.example.ProductManagment.controller;

import java.util.Properties;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ProductManagment.Pojo.User;
import com.example.ProductManagment.Service.UserServiceInterface;

@Controller
public class AuthoController {
	@Autowired
	private UserServiceInterface userServiceInterface;
	@Autowired
	private SessionFactory sfg;

	@Autowired
	private EmailUtil  sendEmail;
    String host = "localhost";

	@GetMapping(value="/login")
	
	public String login(@ModelAttribute User user,Model model, HttpSession session) {
	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session1 = Session.getDefaultInstance(properties);


		System.out.println(user);
		User usr=userServiceInterface.loginuser(user);
		if(usr!=null) {
//			    String sub=user.getUsername()+"welcome";
//			    String sub1=user.getUsername()+" you are added ";
//			session.setAttribute("username", usr.getUsername());
//			sendEmail.sendEmail(session1, user.getEmail(), sub, sub1)
;			return "home";
		}
		
		
		model.addAttribute("msg","invalid creditial!!!!");
		return "login";
	}
	

}
