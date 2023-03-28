package com.ratesdemo.demo;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.ratesdemo.demo.Dao.userRepository;
import com.ratesdemo.demo.Entity.user;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class userRepositoryTests {
	
	@Autowired
	private userRepository repo;

	@Test
	public void testAddnew() {
		user user = new user();
		user.setEmail("karthik1@gmail.com");
		user.setPassword("Karthikr@123");
		user.setFirstname("karthikr");
		user.setLastname("sharma");
		
		user saveduser = repo.save(user);
		
		Assertions.assertThat(saveduser).isNotNull();
		Assertions.assertThat(saveduser.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testListAll() {
		
		Iterable<user> users = repo.findAll();
		Assertions.assertThat(users).hasSizeGreaterThan(0);
		
		
		for (user user : users)
		{
			System.out.println(user);
		}
		
		
	}
	
	@Test
	public void testupdate() {
		Integer userId = 1;
		Optional<user> optionaluser = repo.findById(userId);
		user user = optionaluser.get();
		user.setPassword("hello@123");
		repo.save(user);
		
		user updateduser = repo.findById(userId).get();
		Assertions.assertThat(updateduser.getPassword()).isEqualTo("hello@123");
	}
	
	@Test
	public void testGet() {
		Integer userId = 1;
		Optional<user> optionaluser = repo.findById(userId);
		Assertions.assertThat(optionaluser).isPresent();
		System.out.println(optionaluser.get());
	}
	
	@Test
	public void testDelete() {
		Integer userId = 2;
		repo.deleteById(userId);
		
		Optional<user> optionaluser = repo.findById(userId);
		Assertions.assertThat(optionaluser).isNotPresent();
	}
}
