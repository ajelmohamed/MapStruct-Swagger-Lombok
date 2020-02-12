package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Person;
import com.example.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;

	public List<Person> findAll() {
        return personRepository.findAll();
    }

 

    public Person save(Person person) {
        return personRepository.save(person);
    }

   
}
