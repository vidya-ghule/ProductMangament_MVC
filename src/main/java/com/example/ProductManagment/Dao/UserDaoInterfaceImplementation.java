package com.example.ProductManagment.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ProductManagment.Pojo.Product;
import com.example.ProductManagment.Pojo.User;

@Repository
public class UserDaoInterfaceImplementation implements UserDaoInterface {
	@Autowired
	private SessionFactory sfg;

	@Override
	public User loginuser(User user) {
		Session session=sfg.openSession();
		User usr=null;
		try {
         usr=session.get(User.class,user.getUsername());
			if(usr!=null) {
				if(!usr.getPassword().equals(user.getPassword()))
				{
					usr=null;

				}
			} }
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return usr;
	}

	@Override
	public boolean adduser(User user) {
		Session session=sfg.openSession();
		Transaction transaction=session.beginTransaction();
		boolean d=false;
		try {
			if(user!=null) {
			session.save(user);
			transaction.commit();
			d=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return d;
	}

	@Override
	public boolean addproduct(Product product) {
		Session session=sfg.openSession();
		Transaction transaction=session.beginTransaction();
		boolean d=false;
		try {
			if(product!=null) {
			session.save(product);
			transaction.commit();
			d=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return d;
	}

	@Override
	public List<User> userlist() {
		Session session=sfg.openSession();
		List<User>userlist=null;
		try {
			userlist=session.createCriteria(User.class).list();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}

		return userlist;
	}

	@Override	
	public List<Product> productlist() {
		Session session=sfg.openSession();
		List<Product>productlist=null;
		try {
			productlist=session.createCriteria(Product.class).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return productlist;

	}

	@Override
	public User getuserbyusername(String username) {
		Session session=sfg.openSession();
		User user=null;
		try {
		user=session.get(User.class,username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}

		
		return user;
	}




}
