package com.example.ProductManagment.Dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.ProductManagment.Pojo.Product;
import com.example.ProductManagment.Pojo.User;
import com.example.ProductManagment.Pojo.Users;

public interface UserDaoInterface {
	public User loginuser(User user);
	public boolean adduser(User user);
	public boolean addproduct(Product product);
	public List<User> userlist();
	public List<Product> productlist();
	public User getuserbyusername(String username);
	public boolean updateUser(User user);
	public boolean deleteProduct(String procudtId);
	public Product getProduct(String procudtId);
	
	public String uploadUsers(List<User> userList);
	public boolean deleteUser(String username);
	public int uploadproduct(List<Product> productList);
	public boolean logoutuser(HttpSession session);
	public String forgotcont(User user,HttpSession session);
	
	
	
}
