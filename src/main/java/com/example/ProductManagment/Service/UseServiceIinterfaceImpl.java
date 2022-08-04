package com.example.ProductManagment.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.ProductManagment.Dao.UserDaoInterface;
import com.example.ProductManagment.Pojo.Product;
import com.example.ProductManagment.Pojo.User;
import com.example.ProductManagment.Pojo.Users;
@Service
public class UseServiceIinterfaceImpl implements UserServiceInterface {
@Autowired
private UserDaoInterface userDaoInterface;
	@Override
	public User loginuser(User user) {
		
		return userDaoInterface.loginuser(user);
	}
	@Override
	public boolean addusers(User user) {
	user.setIsactive("inactive");
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
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDaoInterface.updateUser(user);
	}
	@Override
	public boolean deleteProduct(String procudtId) {
		// TODO Auto-generated method stub
		return userDaoInterface.deleteProduct(procudtId);
	}
	@Override
	public Product getProduct(String procudtId) {
		// TODO Auto-generated method stub
		return userDaoInterface.getProduct(procudtId);
	}
public List<User> readExcel(String path) throws IOException{
	List<User> userlist=new ArrayList<>();
		try {
			FileInputStream fis=new FileInputStream(new File(path));
			
			Workbook  workbook=new XSSFWorkbook(fis);
			Sheet sheet=workbook.getSheetAt(0);
			User user=null;
			java.util.Iterator<Row> rows=sheet.rowIterator();
			while(rows.hasNext()) {
				user=new User();
			Row row=rows.next();
			java.util.Iterator<Cell> cell=row.cellIterator();
			while(cell.hasNext())
			{
				Cell cells=cell.next();
				int col=cells.getColumnIndex();
				switch(col)
				{
				case 0:{
					user.setUsername(cells.getStringCellValue());
				break;
				}
				case 1:{
					user.setPassword(cells.getStringCellValue());
					break;}
				case 2:{
					user.setGender(cells.getStringCellValue());
					break;
				}
				case 3:{
					user.setRole(cells.getStringCellValue());
					break;
					
				}
				case 4:{
					user.setQuestion(cells.getStringCellValue());
					break;
				}
				case 5:{
					user.setAnswer(cells.getStringCellValue());
					break;
				}
				}
				
			}userlist.add(user);
			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return userlist;
		
	}
	@Override
	public String uploadSheet(CommonsMultipartFile file, HttpSession session) {
		String filePath = session.getServletContext().getRealPath("/WEB-INF/uploaded");
		System.out.println(filePath);
		String fileName = file.getOriginalFilename();
		byte[] data = file.getBytes();
		String count=null;
		try {
			FileOutputStream fos = new FileOutputStream(new File(filePath + File.separator + fileName));
			fos.write(data);
			
		List<User> userList=readExcel(filePath + File.separator + fileName);
		 count=	userDaoInterface.uploadUsers(userList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	@Override
	public boolean deleteUser(String username) {
		
		return userDaoInterface.deleteUser(username);
	}
	public List<Product> readExcelsheet(String path) throws IOException{
		List<Product> productlist=new ArrayList<>();
			try {
				FileInputStream fis=new FileInputStream(new File(path));
				
				Workbook  workbook=new XSSFWorkbook(fis);
				Sheet sheet=workbook.getSheetAt(0);
				Product product=null;
				DataFormatter formatter = new DataFormatter();
				java.util.Iterator<Row> rows=sheet.rowIterator();
				while(rows.hasNext()) {
					product=new Product();
				Row row=rows.next();
				java.util.Iterator<Cell> cell=row.cellIterator();
				while(cell.hasNext())
				{
					Cell cells=cell.next();
					System.out.println(cells);
					int col=cells.getColumnIndex();
					System.out.println(col);
					switch(col)
					{
					case 0:{
						
						product.setProcudtId(cells.getStringCellValue());
					break;
					}
					case 1:{
						product.setProductName(cells.getStringCellValue());
						break;
						}
					case 2:{
						product.setProductPrice(cells.getNumericCellValue());
						break;
					}
					case 3:{
						product.setProductExpiryDate(cells.getDateCellValue());
						break;
						
					}
					
					}
					
				}productlist.add(product);
				
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			return productlist;
			
		}

	@Override
	public int uploadsheetproduct(CommonsMultipartFile file, HttpSession session) {
		String filePath = session.getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println(filePath);
		String fileName = file.getOriginalFilename();
		System.out.println(fileName);
		byte[] data = file.getBytes();
		int count=0;
		try {
			FileOutputStream fos = new FileOutputStream(new File(filePath + File.separator + fileName));
			fos.write(data);
			System.out.println(fos);
			
		List<Product> productList=readExcelsheet(filePath + File.separator + fileName);
		System.out.println("user"+productList);
		 count=	userDaoInterface.uploadproduct(productList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	
	}
	@Override
	public boolean logoutuser(HttpSession session) {
		// TODO Auto-generated method stub
		return userDaoInterface.logoutuser(session);
	}
	@Override
	public String forgotcont(User user,HttpSession session) {
		// TODO Auto-generated method stub
		return userDaoInterface.forgotcont(user,session);
	}
	
	
}
