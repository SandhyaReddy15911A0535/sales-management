package com.cg.salesManagement.service;

import com.cg.salesManagement.beans.ProductBean;
import com.cg.salesManagement.dao.ProductDao;

public class ProductService  implements IProductService{
	ProductDao pd=new ProductDao();
	public ProductBean getProductDetails(int product_code) {
		// TODO Auto-generated method stub
		
	return	pd.getProductDetails(product_code);
		
		
		
		
	}

	public boolean insertSalesDetails(ProductBean product) {
		// TODO Auto-generated method stub
	 return pd.insertSalesDetails(product);
		
		
	}
	

}
