package com.franco.apirfstockmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franco.apirfstockmanager.repository.CategoryRepository;
import com.franco.apirfstockmanager.requestobject.RequestCategoryInsert;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Object insert(RequestCategoryInsert request) {
		return request;
	}
}
