package com.franco.apirfstockmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.franco.apirfstockmanager.repository.CategoryRepository;

@Controller
@RequestMapping(path = "category")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
}
