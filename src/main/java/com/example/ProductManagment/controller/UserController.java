package com.example.ProductManagment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
@PostMapping(value="/adduserpage")
public String adduser(@ModelAttribute User user,Model model)
	
	{
	boolean isadded=userServiceInterface.addusers(user);
	System.out.println(isadded);
	
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

@RequestMapping(value="/getProfile")
public String profile(@RequestParam String username ,Model model, HttpSession session) {
User usr=userServiceInterface.getuserbyusername(username);
System.out.println(usr.getGender());
model.addAttribute("user", usr);
session.setAttribute("usergender",usr.getGender());

	return "profile";
}
@RequestMapping(value="/getProduct")
public String getProduct(@RequestParam String procudtId ,Model model) {
	Product       product=userServiceInterface.getProduct(procudtId);
model.addAttribute("user", product);
	return "product";
}

@PostMapping(value = "/adduser")
public String updateUser(@ModelAttribute User user, Model model) {
	boolean isUpdated = userServiceInterface.updateUser(user);
	if (isUpdated) {
		model.addAttribute("msg", "Updated !!");
		return "profile";
	} else {
		model.addAttribute("msg", "Not Updated !!");
		return "profile";
	}

}
@GetMapping(value = "/deleteUser")
public String deleteUser(@RequestParam String username, Model model) {

	boolean isDeleted = userServiceInterface.deleteUser(username);
	List<User> userList = userServiceInterface.userlist();
	;
	if (isDeleted) {
		model.addAttribute("msg", "Deleted");
		model.addAttribute("userslist", userList);
		return "userlist";
	} else {
		model.addAttribute("userslist", userList);
		model.addAttribute("msg", "Not Deleted");

		return "userlist";
	}
}
	@GetMapping(value = "/deleteProduct")
	public String deleteProduct(@RequestParam String procudtId, Model model) {

		boolean isDeleted = userServiceInterface.deleteProduct(procudtId);
		List<Product> productlist = userServiceInterface.productlist();
		;
		if (isDeleted) {
			model.addAttribute("msg", "Deleted");
			model.addAttribute("productlist", productlist);
			return "productlist";
		} else {
			model.addAttribute("productlist", productlist);
			model.addAttribute("msg", "Not Deleted");

			return "productlist";
		

		}
}
	@PostMapping(value = "/uploadsheet")
	public String uploadsheet(@RequestParam CommonsMultipartFile file,HttpSession session,Model model ) {
		System.out.println("111");
		String count=	userServiceInterface.uploadSheet(file, session);
	model.addAttribute("count",count);
		return "home";

	}
	@PostMapping(value = "/uploadsheetproduct")
	public String uploadsheetproduct(@RequestParam CommonsMultipartFile file,HttpSession session,Model model ) {
		System.out.println("uploadsheetproduct");
	int count=	userServiceInterface.uploadsheetproduct(file, session);
	model.addAttribute("count",count+" product uploaded");
		return "home";

	}
	
	@GetMapping(value = "/logoutUser")
	public String logoutUser(HttpSession session) {
		
		boolean islogout=userServiceInterface.logoutuser(session);
if(islogout)
		session.invalidate();

		return "login";

	}


}

