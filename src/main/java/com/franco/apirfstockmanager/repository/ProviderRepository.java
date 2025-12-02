package com.franco.apirfstockmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.franco.apirfstockmanager.model.Provider;

@Repository
public class ProviderRepository {
	private final List<Provider> listProviders = new ArrayList<>();
	
	public Provider save(Provider provider) {
		this.listProviders.add(provider);
		return provider;
	}
	
	public List<Provider> findAll(){
		return this.listProviders;
	}
	   
	public Provider findById(String id){
    	for(Provider p : this.listProviders) {
    		if(p.getIdProvider().equalsIgnoreCase(id)) {
    			return p;
    		}
    	}
        return null;
    }
}
