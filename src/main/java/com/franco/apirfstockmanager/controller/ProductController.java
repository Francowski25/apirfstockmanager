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
import com.franco.apirfstockmanager.requestobject.RequestProductInsert;
import com.franco.apirfstockmanager.service.ProductService;

@Controller
@RequestMapping(path = "product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping(path = "insert", consumes = "multipart/form-data")
	public ResponseEntity<?> getall(@ModelAttribute RequestProductInsert request){
		Object response = this.productService.crear(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "list")
	public ResponseEntity<?> getAll() {
		Object response = this.productService.listar();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "findById")
	public ResponseEntity<?> getall(@RequestParam String idProduct){
		Object response = this.productService.findById(idProduct);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
