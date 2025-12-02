package com.franco.apirfstockmanager.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franco.apirfstockmanager.model.Provider;
import com.franco.apirfstockmanager.repository.ProviderRepository;
import com.franco.apirfstockmanager.requestobject.RequestProviderInsert;
import com.franco.apirfstockmanager.responseobject.message.ResponseMessage;
import com.franco.apirfstockmanager.responseobject.provider.ResponseProviderById;
import com.franco.apirfstockmanager.responseobject.provider.ResponseProviderInsert;
import com.franco.apirfstockmanager.responseobject.provider.ResponseProviderList;
import com.franco.apirfstockmanager.util.Message;

@Service
public class ProviderService {
	@Autowired
	private ProviderRepository providerRepository;
	
	public Object insert(RequestProviderInsert request) {
		ResponseMessage message = new ResponseMessage();
		if(request.getRuc().isBlank()) {
			message.setMessage(Message.warning("El ruc no debe estar vacío"));
			return message;
		}
		
		Provider provider = new Provider();
		provider.setIdProvider(UUID.randomUUID().toString());
		provider.setRuc(request.getRuc());
		provider.setPhone(request.getPhone());
		provider.setEmail(request.getEmail());
		provider.setStatus("disponible");
		provider.setCratedAt(new Date());
		this.providerRepository.save(provider);
		
		ResponseProviderInsert response = new ResponseProviderInsert();
		response.setIdProvider(provider.getIdProvider());
		response.setRuc(provider.getRuc());
		response.setPhone(provider.getPhone());
		response.setEmail(provider.getEmail());
		response.setStatus(provider.getStatus());
		response.setCratedAt(provider.getCratedAt());
		
		return response;
	}
	
	public Object findAll() {
		ResponseMessage message = new ResponseMessage();
		List<Provider> providers = this.providerRepository.findAll();
		if(providers.isEmpty()) {
			message.setMessage(Message.error("No existe proveedores en el sistema"));
			return message;
		}
		ResponseProviderList response = new ResponseProviderList();
		response.setProviders(providers);;
		return response;
	}
	
    public Object findById(String idProvider) {
        ResponseMessage message = new ResponseMessage();
    	Provider provider = this.providerRepository.findById(idProvider);
    	if(provider == null) {
    		message.setMessage(Message.error("El proveedor buscado no existe en el sistema"));
    		return message; 
    	}
    	ResponseProviderById response = new ResponseProviderById();
    	response.setProvider(provider);
    	return response;
    }

}
