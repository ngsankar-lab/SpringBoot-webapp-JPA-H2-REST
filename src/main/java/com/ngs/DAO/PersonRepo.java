package com.ngs.DAO;

import org.springframework.data.repository.CrudRepository;

import com.ngs.model.Person;

public interface PersonRepo extends CrudRepository<Person, Integer> {

}
