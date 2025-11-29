package com.franco.apirfstockmanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.franco.apirfstockmanager.model.Product;
import com.franco.apirfstockmanager.repository.ProductRepository;
import com.franco.apirfstockmanager.requestobject.RequestProductInsert;
import com.franco.apirfstockmanager.responseobject.ResponseMessage;
import com.franco.apirfstockmanager.responseobject.ResponseProductById;
import com.franco.apirfstockmanager.responseobject.ResponseProductInsert;
import com.franco.apirfstockmanager.responseobject.ResponseProductList;
import com.franco.apirfstockmanager.responseobject.ResponseProductStatus;
import com.franco.apirfstockmanager.util.Message;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public Object crear(RequestProductInsert request){
        ResponseMessage message = new ResponseMessage();
        ResponseProductStatus status = new ResponseProductStatus();
        
    	if(request.getName() == null || request.getName().isBlank()) {
            message.setMessage(Message.warning("El nombre no debe estar vacío"));
            return message;
        }
    	if(request.getCategory() == null || request.getCategory().isBlank()) {
            message.setMessage(Message.warning("La categoría no debe estar vacío"));
            return message;
        }
    	if (request.getMinStock() == null || request.getStock() == null) {
    	    message.setMessage(Message.warning("Los stocks no deben estar vacios"));
    	    return message;
    	}
    	if(request.getStock() < 0) {
            message.setMessage(Message.warning("El stock no debe ser menor que 0"));
            return message;
        }
    	if(request.getMinStock() > request.getStock()) {
            message.setMessage(Message.warning("El stock mínimo no debe ser mayor que el stock"));
            return message;
        }
    	if(request.getPrice() == null) {
    		message.setMessage(Message.warning("El precio debe ser mayor a 0.0"));
    		return message;
    	}
      	Product product = new Product();
        product.setIdProduct(UUID.randomUUID().toString());
        product.setCategory(request.getCategory());
        product.setName(request.getName());
        product.setStock(request.getStock());
        product.setMinStock(request.getMinStock());
        product.setPrice(request.getPrice());
        product.setStatus(status.isStatus(request.getStock()));
        this.productRepository.save(product);


    	ResponseProductInsert response = new ResponseProductInsert();
        response.setIdProduct(product.getIdProduct());
        response.setCategory(product.getCategory());
        response.setName(product.getName());
        response.setStock(product.getStock());
        response.setMinStock(product.getMinStock());
        response.setPrice(product.getPrice());
        response.setStatus(product.getStatus());
        
		return response;
    }
    
    public Object listar(){
        ResponseMessage message = new ResponseMessage();
        List<Product> products = this.productRepository.findAll();
        if(products.isEmpty()) {
        	message.setMessage(Message.error("No existe productos en la lista"));
        	return message;
        }
        
        ResponseProductList response = new ResponseProductList();
        response.setProducts(products);
    	return response;
    }
    
    public Object findById(String idProduct) {
        ResponseMessage message = new ResponseMessage();
    	Product product = this.productRepository.findById(idProduct);
    	if(product == null) {
    		message.setMessage(Message.error("El producto buscado no existe en el sistema"));
    		return message; 
    	}
    	ResponseProductById response = new ResponseProductById();
    	response.setProduct(product);
    	return response;
    }
}
