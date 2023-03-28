package com.ratesdemo.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ratesdemo.demo.Entity.product;

@Repository
public interface productRepository extends JpaRepository<product , Long>{
	
	@Query(value="select * from product e where e.name like %:keyword%" , nativeQuery=true)
	List<product> findbyproductkeyword(@Param("keyword") String keyword);

	
}
