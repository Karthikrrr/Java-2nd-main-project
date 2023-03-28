package com.ratesdemo.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratesdemo.demo.Dao.productRepository;
import com.ratesdemo.demo.Entity.product;

@Service
public class productservicesimplementation {
	@Autowired
	productRepository product;
	
	public List<product> getAllproducts() {
		return product.findAll();
	}

	public List<product> findbyproductkeyword(String keyword) {
		return product.findbyproductkeyword(keyword);
	}

	
}
