package com.example.demo.person.service;

import com.example.demo.person.repository.PersonRepository;
import com.example.demo.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private  PersonRepository personRepository;


    public List<Person> trouverToutesLesPersonnes() {
        return personRepository.findAll();
    }

    public Optional<Person> PersonById(int id) {
        return personRepository.findById(id);
    }


    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }
}
