package com.franco.apirfstockmanager.responseobject.category;

import java.util.List;

import com.franco.apirfstockmanager.model.Category;

public class ResponseCategoryList {
	private List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
