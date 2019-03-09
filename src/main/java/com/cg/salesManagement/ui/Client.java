package com.cg.salesManagement.ui;

import java.util.Scanner;

import com.cg.salesManagement.beans.ProductBean;
import com.cg.salesManagement.service.IProductService;
import com.cg.salesManagement.service.ProductService;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IProductService ips=new ProductService();
		ProductBean product=new ProductBean();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter ur choice");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:System.out.println("enter product code");
		int code=sc.nextInt();
		//System.out.println("enter the number of quantity");
		//int quantity=sc.nextInt();
		product=ips. getProductDetails(code);
	
		ips.insertSalesDetails(product);
		
		
		
		
		}

	}

}
