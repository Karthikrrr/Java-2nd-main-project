package com.ratesdemo.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ratesdemo.demo.Entity.product_Category;

@Repository
public interface productCategoryRepository extends JpaRepository<product_Category , Long> {
	
@Query(value="select * from product_category e where e.category_name like %:keyword%", nativeQuery=true)
	List<product_Category> findbykeyword(@Param("keyword") String keyword);
	
@Query(value = "select id from product_category e where e.id like %:id%" , nativeQuery=true)
    List<product_Category> categoryByproduct(@Param("id") Long id);
}
