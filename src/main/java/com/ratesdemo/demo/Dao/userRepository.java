package com.ratesdemo.demo.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ratesdemo.demo.Entity.user;

@Repository
public interface userRepository extends CrudRepository<user , Integer> {

}
