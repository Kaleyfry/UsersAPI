package com.tts.UsersAPI.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tts.UsersAPI.model.User;
import com.tts.UsersAPI.repository.Repository;

@RestController
public class controller {
	
	@Autowired
	private Repository repository;
	
	@GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(@PathVariable(value="id")  Long id,
    											@RequestParam(value="first_name", required=false) String first_name,
    											@RequestParam(value="last_name", required=false) String last_name,
    											@RequestParam(value="state", required=false) String state) {
		if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		List<User> users;
		if (state!=null) {
			users = repository.findByState(state);
		}
		users = (List<User>) repository.findAll();
		return new ResponseEntity<List<User>>(HttpStatus.OK);
	}
		
	
//	@GetMapping("/users")
//    public List<User> getUsers(@RequestParam(value="state", required=false) String state){
//		if (state != null) {
//            return (List<User>) repository.findByState(state);
//        }
//		return (List<User>) repository.findAll();
//    }
	
	
	@GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable(value="id") Long id){
		Optional<User> user = repository.findById(id);
		List<User> users;
		if (!user.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		repository.findById(id);
		return new ResponseEntity<Optional<User>>(HttpStatus.OK);
    }
	
//	@GetMapping("/users/{id}")
//    public Optional<User> getUserById(@PathVariable(value="id") Long id){
//        return repository.findById(id);
//    }
	
	 @PostMapping("/users")
		public ResponseEntity<Void> createUser(@RequestBody @Valid User user,
												BindingResult bindingResult){
		 if (bindingResult.hasErrors())  {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 }
		 repository.save(user);
		    return new ResponseEntity<>(HttpStatus.CREATED);
		    
		}
	 
	 @PutMapping("/users/{id}")
		public ResponseEntity<Void> updateUser(@PathVariable(value="id") Long id, @RequestBody @Valid User user,
																		BindingResult bindingResult){
		 
		 if (id == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 if (bindingResult.hasErrors()) {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 }
		 repository.save(user);
		 return new ResponseEntity<>(HttpStatus.CREATED);
			}
	 
	 @DeleteMapping("/users/{id}")
		public ResponseEntity<Void> createUser(@PathVariable(value="id") Long id){
		 if (id == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 repository.deleteById(id);
		 return new ResponseEntity<>(HttpStatus.OK);
		}
	 
//	 @DeleteMapping("/users/{id}")
//		public void createUser(@PathVariable(value="id") Long id){
//		    repository.deleteById(id);
//		}
	 
	 

}
