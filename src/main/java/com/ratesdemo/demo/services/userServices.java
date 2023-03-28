package com.ratesdemo.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratesdemo.demo.Dao.userRepository;
import com.ratesdemo.demo.Entity.user;

@Service
public class userServices {
	
	@Autowired private userRepository repo;
	
	
	public List<user> listAll(){
		
		return (List<user>) repo.findAll();
	}


	public void save(user user) {
		repo.save(user);
	}
	
	public user get(Integer id) throws UserNotFoundException {
		Optional<user> result = repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		throw new UserNotFoundException("could not find any user with Id" + id);
	}

}
