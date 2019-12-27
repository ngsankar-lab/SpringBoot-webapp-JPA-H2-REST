package com.ngs.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ngs.DAO.PersonRepo;
import com.ngs.model.Person;

@RestController
public class PersonController {
	
	@Autowired
	PersonRepo repo;
	
	@RequestMapping("/")
	public String Home() {
		return "home.jsp";
	}
	
	@PostMapping("/person")
	public Person addPerson(@RequestBody Person person) {
		repo.save(person);
		return person;
	}	
	
	@PutMapping("/person")
	public Person saveOrUpdatePerson(@RequestBody Person person) {
		repo.save(person);
		return person;
	}	
	@DeleteMapping("/person/{pid}")
	public Optional<Person> deletePerson(@PathVariable int pid) {
		Optional<Person> p=repo.findById(pid);
		repo.deleteById(pid);
		return p;
		
	}
	
	
	@RequestMapping(path="/persons", produces={"application/xml","application/json"})
	public List<Person> getPersons() {
	System.out.println("From getpersons method");
	return (List<Person>) repo.findAll();
	}
	
	@RequestMapping("/person/{pid}")
	public Optional<Person> getPerson(@PathVariable("pid") int pid) {
	System.out.println("From getperson method");
	return repo.findById(pid);
	}
}
