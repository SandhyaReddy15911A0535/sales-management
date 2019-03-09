package com.cg.salesManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;
import java.util.Scanner;

import com.cg.salesManagement.beans.ProductBean;

public class ProductDao implements IProductDao {
	ProductBean pb=new ProductBean();
	Scanner sc=new Scanner(System.in);
	public ProductBean getProductDetails(int product_code) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_management", "root", "root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from product");
			while(rs.next()){
				if(rs.getInt(1)==product_code) {
					pb.setProduct_code(rs.getInt(1));
				pb.setProduct_name(rs.getString(2));
				pb.setProduct_category(rs.getString(3));
				pb.setProduct_description(rs.getString(4));
				pb.setProduct_price(rs.getInt(5));
				
				System.out.println("product exists");
				
				}
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pb;
	}

	public boolean insertSalesDetails(ProductBean pb) {
		// TODO Auto-generated method stub
		
		//Date d=new Date();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_management", "root", "root");
			PreparedStatement ps=con.prepareStatement("insert into sales values(?,?,?,?,?)");
			System.out.println("enter sales id");
			ps.setInt(1,sc.nextInt());
			int pcode=pb.getProduct_code();
			ps.setInt(2, pcode);
			System.out.println("enter the quantity");
			int quantity=sc.nextInt();
			ps.setInt(3, quantity);
			
			ps.setDate(4,Date.valueOf(LocalDate.now()));
			
			ps.setInt(5,pb.getProduct_price()*quantity );
			int i=ps.executeUpdate();
			if(i==1)
				System.out.println("inserted");
			else
				System.out.println("not inserted");
			
		
			System.out.println("product name:"+pb.getProduct_name());
			System.out.println("product category :"+pb.getProduct_category());
		System.out.println("product description: "+pb.getProduct_description());
			System.out.println("product price: "+pb.getProduct_price());
			System.out.println("quantity :"+((ResultSet) ps).getInt(5));
			System.out.println("total line: "+pb.getLine_total());
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	

}
