package com.example.ProductManagment.Dao;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.ProductManagment.Pojo.Product;
import com.example.ProductManagment.Pojo.User;
import com.example.ProductManagment.Pojo.Users;

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
			//usr.setIsactive("acive");
			//session.update(usr);
	
			if(usr!=null) {
				if(!usr.getPassword().equals(user.getPassword()))
				{
					usr=null;

				}
					}
			
		
		}
		
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

	@Override
	public boolean updateUser(User user) {
		Session session = sfg.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;
		try {

			session.update(user);
			transaction.commit();
			isUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isUpdated;
	}

	@Override
	public boolean deleteProduct(String procudtId) {
		Session session = sfg.openSession();
		Transaction transaction = session.beginTransaction();
		boolean b = false;
		try {
			Product product = session.get(Product.class, procudtId);
			if (product != null) {
				session.delete(product);
				transaction.commit();
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return b;
	}

	@Override
	public Product getProduct(String procudtId) {
		Session session=sfg.openSession();
		Product product=null;
		try {
			product=session.get(Product.class,procudtId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}


		return product;
	}

	@Override
	public String uploadUsers(List<User> userList) {
		Session session = sfg.openSession();
		Transaction transaction = session.beginTransaction();

		int count=0,exclude=0;
		try {
			System.out.println(Arrays.toString(userList.toArray()));
			for (User user : userList) {
				User usr=session.get(User.class,user.getUsername());
				if(usr.getUsername().equals(user.getUsername())) {
					exclude++;
					}
				else {
					System.out.println("in else");
					
				session.save(user);
					transaction.commit();
					count++;
		}

					
				System.out.println("after if");
			}
			
		} catch (Exception e) {

			// TODO: handle exception
		}	finally {
			session.close();
		}
		return count+" inserted"+exclude+" duplicate entry";
	}

	@Override
	public boolean deleteUser(String username) {
		Session session = sfg.openSession();
		Transaction transaction = session.beginTransaction();
		boolean b = false;
		try {
			User username1 = session.get(User.class,username);
			if (username1 != null) {
				session.delete(username1);
				transaction.commit();
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return b;
	}

	@Override
	public int uploadproduct(List<Product> productList) {
		Session session =null;
		int count=0;
		try {
			for (Product product : productList) {
				session = sfg.openSession();
				Transaction transaction = session.beginTransaction();
				session.save(product);
				transaction.commit();
				count++;
			}

		} catch (Exception e) {

			// TODO: handle exception
		}	finally {
			session.close();
		}
		return count;
	}

	@Override
	public boolean logoutuser(HttpSession session) {
		Session session1=sfg.openSession();
		Transaction transaction=session1.beginTransaction();
		String isactive=(String) session.getAttribute("isactive");
		String usrname=(String) session.getAttribute("username");
		boolean d=false;
		try {
		User user=session1.get(User.class, usrname);
		user.setIsactive("inactive");
		session1.update(user);
			
				transaction.commit();
				d=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			session1.close();
		}
		return d;
	}

	@Override
	public String forgotcont(User user ,HttpSession session) {
		Session session1=sfg.openSession();
		Transaction transaction=session1.beginTransaction();
     	User usr=null;
		
		try {
			usr=session1.get(User.class,user.getUsername());
			if(usr==null || usr.getUsername().equals(user.getUsername()))
			{
				return null;
			}else
			{
				return "user not exist!!!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
			return null;
	}


}







