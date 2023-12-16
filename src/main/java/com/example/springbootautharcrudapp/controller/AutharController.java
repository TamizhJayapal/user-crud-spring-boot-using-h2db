package com.example.springbootautharcrudapp.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.springbootautharcrudapp.repository.AutharRepository;
import com.example.springbootautharcrudapp.model.Authar;

import java.util.*;

@RestController
public class AutharController {
	private static final Logger logger = LoggerFactory.getLogger(AutharController.class);
	
	@Autowired
	private AutharRepository repository;

	@GetMapping("/getAllAuthar")
	public ResponseEntity<List<Authar>> getAllAuthar() {
		try {
			List<Authar> autharList = new ArrayList<>();
			repository.findAll().forEach(autharList::add);
			if (autharList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(autharList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAutharById/{id}")
	public ResponseEntity<Authar> getAutharById(@PathVariable int id) {
		try {
			Optional<Authar> authar = repository.findById(id);
			if (authar.isPresent()) {
				return new ResponseEntity<>(authar.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addAuthar")
	public ResponseEntity<Authar> addAuthar(@RequestBody Authar authar) {
		System.err.println(authar);	
		 logger.info("Received Request Body: {}", authar.getName());
		Authar autharObj = repository.save(authar);
		System.out.println(autharObj);
		return new ResponseEntity<>(autharObj, HttpStatus.OK);
	}

	@PostMapping("/updateAutharById/{id}")
	public ResponseEntity<Authar> UpdateAutharById(@PathVariable int id, @RequestBody Authar newAuthar) {
		Optional<Authar> oldAuthar = repository.findById(id);
		if (oldAuthar.isPresent()) {
			newAuthar.setId(id);
			Authar updatedAuthar = repository.save(newAuthar);
			return new ResponseEntity<>(updatedAuthar, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/deleteAutharById/{id}")
	public ResponseEntity<HttpStatus> deleteAutharById(@PathVariable int id) {
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
