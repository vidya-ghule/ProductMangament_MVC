package com.example.ProductManagment.Dao;

import java.util.List;

import com.example.ProductManagment.Pojo.Product;
import com.example.ProductManagment.Pojo.User;

public interface UserDaoInterface {
	public User loginuser(User user);
	public boolean adduser(User user);
	public boolean addproduct(Product product);
	public List<User> userlist();
	public List<Product> productlist();
	public User getuserbyusername(String username);
	
	
}
