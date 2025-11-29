package com.franco.apirfstockmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.franco.apirfstockmanager.requestobject.RequestCategoryInsert;
import com.franco.apirfstockmanager.service.CategoryService;

@Controller
@RequestMapping(path = "category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping(path = "insert", consumes = "multipart/form-data")
	public ResponseEntity<?> getall(@ModelAttribute RequestCategoryInsert request){
		Object response = this.categoryService.insert(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "list")
	public ResponseEntity<?> getAll() {
		Object response = this.categoryService.listar();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "findById")
	public ResponseEntity<?> getall(@RequestParam String idCategory){
		Object response = this.categoryService.findById(idCategory);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
