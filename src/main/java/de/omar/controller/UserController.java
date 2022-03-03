package de.omar.controller;

import de.omar.exception.ResourceNotFoundException;
import de.omar.model.User;
import de.omar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return repo.findAll();
	}
	
	@PostMapping("/users")
	public User create(@RequestBody User position) {
		return repo.save(position);
	}


	@GetMapping("/users/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id) {
		User client= repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(client);
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User c){
		User client = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Devis not exist with id :" + id));
		User updated = repo.save(client);
		System.out.println("Saved");
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id){
		User client = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		repo.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
