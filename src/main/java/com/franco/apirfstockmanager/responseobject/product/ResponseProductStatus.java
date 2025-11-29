package com.franco.apirfstockmanager.responseobject.product;

public class ResponseProductStatus {
	private String status;
	
	public String isStatus(Integer stock) {
		if(stock > 0) {
			return "disponible";
		}
		return "ocupado";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
