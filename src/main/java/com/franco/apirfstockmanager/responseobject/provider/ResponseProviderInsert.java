package com.franco.apirfstockmanager.responseobject.provider;

import java.util.Date;

public class ResponseProviderInsert {
	private String idProvider;
	private String ruc;
	private int phone;
	private String email;
	private String status;
	private Date cratedAt;
	
	public String getIdProvider() {
		return idProvider;
	}
	public void setIdProvider(String idProvider) {
		this.idProvider = idProvider;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCratedAt() {
		return cratedAt;
	}
	public void setCratedAt(Date cratedAt) {
		this.cratedAt = cratedAt;
	}
}
