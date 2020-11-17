package com.wallet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	private static final String EMAIL = "email@teste.com.br";
	
	@Autowired
	UserRepository repository;
	
	// All instructions will be executed before the tests.
	@Before
	public void setUp() {
		User u = new User();
		u.setName("Rodisvaldo Testerino");
		u.setPassword("123senha123");
		u.setEmail(EMAIL);
		
		repository.save(u);
	}
	
	// All instructions will be executed after the tests.
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void testSave() {
		User u = new User();
		u.setName("Teste");
		u.setPassword("123456");
		u.setEmail("gabriel@teste");
		
		User response = repository.save(u);
		
		// Checks if the response isn't null;
		assertNotNull(response);
	}
	
	public void testFindByEmail() {
		
		// Using Optional because this user might not really exists.
		Optional<User> response = repository.findByEmailEquals(EMAIL);
		
		// Validate if the user exists.
		assertTrue(response.isPresent());
		
		// Validate if the user has the exactly same e-mail that we are passing.
		assertEquals(response.get().getEmail(), EMAIL);
	}
	
	
}
