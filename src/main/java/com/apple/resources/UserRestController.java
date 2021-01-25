package com.apple.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apple.exception.UserNotFoundException;

@RestController
public class UserRestController {

	@Autowired
	private UserDaoService daoService;

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return daoService.findAll();
	}

	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id) {
		User user = daoService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("Id-"+id);
		}
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = daoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}
}
