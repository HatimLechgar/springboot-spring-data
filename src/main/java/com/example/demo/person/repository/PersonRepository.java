package com.example.demo.person.repository;

import com.example.demo.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    // Define a method to find a person by their first name

    public List<Person> findByFirstName(String firstName);
    public List<Person> findByAge( Integer age);
    public Optional<Person> findByCin(String cin);
    public List<Person> findByFirstNameAndLastName(String firstName,String lastName);
    



    @Query(value="select * from Person")
    public List<Person> titi(String arg);

}
