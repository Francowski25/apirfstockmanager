package com.franco.apirfstockmanager.model;

public class Category {
	    private String idCategory;
	    private String name;
	    private String description;
	    private boolean status;

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

	    public boolean isStatus() {
	        return status;
	    }

	    public void setStatus(boolean status) {
	        this.status = status;
	    }
}
