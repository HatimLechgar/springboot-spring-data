package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.person.model.Person;
import com.example.demo.person.repository.PersonRepository;
import com.example.demo.person.service.PersonService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/rest/person")
public class PersonRestController {

	@Autowired
	private PersonService personService;


	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json" )
	public ResponseEntity<Person> createPersonWithEntityManager(@RequestBody Person person) {
		
		personService.savePerson(person);
		return ResponseEntity.ok(person);

	}



	@GetMapping("/info/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {
       
	   Optional<Person> personOptional = personService.findPersonById(id);
	   Person person =  personOptional.orElse(new Person());
        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.notFound().build();
        }

    }



}