package com.example.ProductManagment.Service;

import java.util.List;

import com.example.ProductManagment.Pojo.Product;
import com.example.ProductManagment.Pojo.User;

public interface UserServiceInterface {

	public User loginuser(User user); //
	public boolean addusers(User user);
	public boolean addproduct(Product product);
	public List<User> userlist();
	public List<Product> productlist();
	public User getuserbyusername(String username);
	
}
