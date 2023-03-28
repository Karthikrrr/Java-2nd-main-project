package com.ratesdemo.demo.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ratesdemo.demo.Dao.productCategoryRepository;
import com.ratesdemo.demo.Entity.product_Category;

@Service
public class productCategoryservicesimplementation{

	@Autowired
	productCategoryRepository procat;
	
	

	public List<product_Category> findAllCategoryes() {
		return procat.findAll();
	}
	
	public List<product_Category> findbykeyword(String keyword){
		return procat.findbykeyword(keyword);
	}

	public List<product_Category> categoryByproduct(Long id){
		return procat.categoryByproduct(id);
	}


	

}
