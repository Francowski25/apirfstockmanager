package com.franco.apirfstockmanager.responseobject.product;

import java.util.List;

import com.franco.apirfstockmanager.model.Product;

public class ResponseProductList {
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
