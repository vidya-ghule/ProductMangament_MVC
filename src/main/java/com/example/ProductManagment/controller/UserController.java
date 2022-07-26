package com.example.ProductManagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProductManagment.Pojo.Product;
import com.example.ProductManagment.Pojo.User;
import com.example.ProductManagment.Service.UserServiceInterface;

@Controller
public class UserController {
	@Autowired
	private UserServiceInterface userServiceInterface;
// we can use below both type
	//1.modeland view
	//model and view is send only one value
//	@PostMapping(value="/adduser")
//	
//	public ModelAndView adduser()
//	{
//		return new ModelAndView("page name""key""value");
//		
//	}
	//2.with String
@PostMapping(value="/adduser")
public String adduser(@ModelAttribute User user,Model model)
	
	{
	boolean isadded=userServiceInterface.addusers(user);
	
	if(isadded) {
		model.addAttribute("msg","user added");

		return "user";
	}else {
		model.addAttribute("msg","user not added");

		return "user";
	}
	}


@GetMapping(value="/userlist")

public String userlist(Model model)
{
List <User> userslist=userServiceInterface.userlist();
for (User user : userslist) {
	System.out.println("userlist");
}

	model.addAttribute("userslist",userslist);

	return "userlist";

}

@GetMapping(value="/productlist")

public String productlist(Model model)
{
	List <Product> productlist=userServiceInterface.productlist();

	model.addAttribute("productlist",productlist);

	return "productlist";
}

@RequestMapping(value="/profile")
public String profile(@RequestParam String username ,Model model) {
User usr=userServiceInterface.getuserbyusername(username);
model.addAttribute("user", usr);
	return "profile";
}
}

