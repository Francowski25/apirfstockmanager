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

import com.franco.apirfstockmanager.requestobject.RequestProviderInsert;
import com.franco.apirfstockmanager.service.ProviderService;

@Controller
@RequestMapping(path = "provider")
public class ProviderController {
	@Autowired
	private ProviderService providerService;
	
	@PostMapping(path = "insert", consumes = "multipart/form-data")
	public ResponseEntity<?> getall(@ModelAttribute RequestProviderInsert request){
		Object response = this.providerService.insert(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "list")
	public ResponseEntity<?> getAll() {
		Object response = this.providerService.findAll();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "findById")
	public ResponseEntity<?> getall(@RequestParam String idProvider){
		Object response = this.providerService.findById(idProvider);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
