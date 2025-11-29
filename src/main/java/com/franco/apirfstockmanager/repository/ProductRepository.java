package com.franco.apirfstockmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.franco.apirfstockmanager.model.Product;

@Repository
public class ProductRepository {
    private final List<Product> listProduct = new ArrayList<>();

    public List<Product> findAll(){
        return this.listProduct;
    }

    public Product save(Product product){
        this.listProduct.add(product);
        return product;
    }

    public Product findById(String id){
    	for(Product p : this.listProduct) {
    		if(p.getIdProduct().equalsIgnoreCase(id)) {
    			return p;
    		}
    	}
        return null;
    }
}
