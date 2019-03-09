package com.cg.salesManagement.service;

import com.cg.salesManagement.beans.ProductBean;

public interface IProductService {

	ProductBean getProductDetails(int product_code);
	boolean insertSalesDetails(ProductBean product);
}
