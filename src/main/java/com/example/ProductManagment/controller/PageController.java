package com.example.ProductManagment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
		
		@RequestMapping(value="/")
		public String page() {
			return "login";
		}
		
		@RequestMapping(value="/adduserpage")
		public String adduserpage() {
			return "user";
		}
		
		@RequestMapping(value="/addproductpage")
		public String addproductpage() {
			return "product";
		}

		@RequestMapping(value = "/importUsersPage")
		public String importUsersPage() {
			return "importUsers";
			
		}
		
		@RequestMapping(value = "/importproductPage")
		public String importproductPage() {
			return "importProduct";
			
		}
		@RequestMapping(value = "/forgotcont")
		public String forgotcont() {
			System.out.println("forgotcont");
			return "forgotpass";
			
		}
		
}
