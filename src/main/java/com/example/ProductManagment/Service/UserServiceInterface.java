package com.example.ProductManagment.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.ProductManagment.Pojo.Product;
import com.example.ProductManagment.Pojo.User;
import com.example.ProductManagment.Pojo.Users;

public interface UserServiceInterface {

	public User loginuser(User user); //
	public boolean addusers(User user);
	public boolean addproduct(Product product);
	public List<User> userlist();
	public List<Product> productlist();
	public User getuserbyusername(String username);
	public boolean updateUser(User user);
	public boolean deleteProduct(String procudtId);
	public boolean deleteUser(String username);
	public Product getProduct(String procudtId);
	public String uploadSheet(CommonsMultipartFile file, HttpSession session);
	public int uploadsheetproduct(CommonsMultipartFile file, HttpSession session);
	public boolean logoutuser(HttpSession session);

	String forgotcont(User user, HttpSession session);
	
}
