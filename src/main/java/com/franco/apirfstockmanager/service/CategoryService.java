package com.franco.apirfstockmanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franco.apirfstockmanager.model.Category;
import com.franco.apirfstockmanager.repository.CategoryRepository;
import com.franco.apirfstockmanager.requestobject.RequestCategoryInsert;
import com.franco.apirfstockmanager.responseobject.category.ResponseCategoryById;
import com.franco.apirfstockmanager.responseobject.category.ResponseCategoryInsert;
import com.franco.apirfstockmanager.responseobject.category.ResponseCategoryList;
import com.franco.apirfstockmanager.responseobject.message.ResponseMessage;
import com.franco.apirfstockmanager.util.Message;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Object insert(RequestCategoryInsert request) {
		ResponseMessage message = new ResponseMessage();
		
		if(request.getName().isBlank()) {
			message.setMessage(Message.warning("El nombre no debe estar vacio"));
			return message;
		}
		if(request.getDescription().isBlank()) {
			message.setMessage(Message.warning("La descripción no debe estar vacio"));
			return message;
		}
		Category category = new Category();
		category.setIdCategory(UUID.randomUUID().toString());
		category.setName(request.getName());
		category.setDescription(request.getDescription());
		category.setStatus("disponible");
        this.categoryRepository.save(category);

		ResponseCategoryInsert response = new ResponseCategoryInsert();
		response.setIdCategory(category.getIdCategory());
		response.setName(category.getName());
		response.setDescription(category.getDescription());
		response.setStatus(category.getStatus());
		
		return response;
	}
	
    public Object listar(){
        ResponseMessage message = new ResponseMessage();
        List<Category> categories = this.categoryRepository.findAll();
        if(categories.isEmpty()) {
        	message.setMessage(Message.error("No existe categorias en la lista"));
        	return message;
        }
        
        ResponseCategoryList response = new ResponseCategoryList();
        response.setCategories(categories);
    	return response;
    }
    
    public Object findById(String idCategory) {
        ResponseMessage message = new ResponseMessage();
    	Category category = this.categoryRepository.findById(idCategory);
    	if(category == null) {
    		message.setMessage(Message.error("La categoria buscado no existe en el sistema"));
    		return message; 
    	}
    	ResponseCategoryById response = new ResponseCategoryById();
    	response.setCategory(category);
    	return response;
    }
}
