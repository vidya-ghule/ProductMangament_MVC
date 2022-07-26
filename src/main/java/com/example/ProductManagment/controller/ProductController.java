package com.example.ProductManagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ProductManagment.Pojo.Product;
import com.example.ProductManagment.Service.UserServiceInterface;

@Controller
public class ProductController {
	@Autowired
	private UserServiceInterface userServiceInterface;
	@PostMapping(value="/addproduct")
		public String addproduct(@ModelAttribute Product product,Model model)
		{
		boolean isadded=userServiceInterface.addproduct(product);
		System.out.println(isadded);
		if(isadded) {
			model.addAttribute("msg","product is added");

			return "product";
		}else {
			model.addAttribute("msg","product is not added");

			return "product";
		}

	}
}
