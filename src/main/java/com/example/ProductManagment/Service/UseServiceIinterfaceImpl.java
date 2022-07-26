package com.example.ProductManagment.Service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductManagment.Dao.UserDaoInterface;
import com.example.ProductManagment.Pojo.Product;
import com.example.ProductManagment.Pojo.User;
@Service
public class UseServiceIinterfaceImpl implements UserServiceInterface {
@Autowired
private UserDaoInterface userDaoInterface;
	@Override
	public User loginuser(User user) {
		// TODO Auto-generated method stub
		return userDaoInterface.loginuser(user);
	}
	@Override
	public boolean addusers(User user) {
		// TODO Auto-generated method stub
		return userDaoInterface.adduser(user);
	}
	
	@Override
	public boolean addproduct(Product product) {
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
	product.setProcudtId(timeStamp);
		return userDaoInterface.addproduct(product);
	}
	@Override
	public List<User> userlist() {
		// TODO Auto-generated method stub
		return userDaoInterface.userlist();
	}
	@Override
	public List<Product> productlist() {
		// TODO Auto-generated method stub
		return userDaoInterface.productlist();
	}
	@Override
	public User getuserbyusername(String username) {
		// TODO Auto-generated method stub
		return userDaoInterface.getuserbyusername(username);
	}
	
	
}
