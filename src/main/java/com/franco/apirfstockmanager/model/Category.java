package com.franco.apirfstockmanager.model;

import java.util.Date;

public class Category {
	    private String idCategory;
	    private String name;
	    private String description;
	    private String status;
	    private Date createdAt;

	    public String getIdCategory() {
	        return idCategory;
	    }

	    public void setIdCategory(String idCategory) {
	        this.idCategory = idCategory;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}


}
