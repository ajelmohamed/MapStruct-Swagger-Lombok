package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PersonDto;
import com.example.entity.Person;
import com.example.mapper.PersonMapper;
import com.example.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/persons")
@Api(description = "recuperer la liste des personnes")
public class PersonController {
	
	
	
	@Autowired
	PersonService personService;
    
    PersonMapper personMapper;
    
	@GetMapping
	@ApiResponses(@ApiResponse(code = 200,message = "ok"))
    public ResponseEntity<List<PersonDto>> findAll() {
        return ResponseEntity.ok(PersonMapper.INSTANCE.toPersonDtos(personService.findAll()));
    }

    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody PersonDto personDto) {
    	System.out.println(personDto);
    	Person p=new Person();
    	System.out.println(p);
    	p=PersonMapper.INSTANCE.toPerson(personDto);
    	
    	System.out.println(p);
        personService.save(p);

        return ResponseEntity.status(HttpStatus.CREATED).body(personDto);
    }
}
