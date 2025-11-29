package com.franco.apirfstockmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.franco.apirfstockmanager.model.Category;

@Repository
public class CategoryRepository {
	private final List<Category> listCategories = new ArrayList<>();

	public List<Category> findAll() {
		return this.listCategories;
	}
	
	public Category save(Category category) {
		this.listCategories.add(category);
		return category;
	}
    public Category findById(String id){
    	for(Category c : this.listCategories) {
    		if(c.getIdCategory().equalsIgnoreCase(id)) {
    			return c;
    		}
    	}
        return null;
    }
}
