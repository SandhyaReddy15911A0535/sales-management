package com.cg.salesManagement.dao;

import com.cg.salesManagement.beans.ProductBean;

public interface IProductDao {

	ProductBean getProductDetails(int product_code);
	boolean insertSalesDetails(ProductBean product);
	
}
