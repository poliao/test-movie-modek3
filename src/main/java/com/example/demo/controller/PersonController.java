package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/tickets")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person getTicketById(@PathVariable(name = "id") Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Person createTicket(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public Person updatePoster(@PathVariable(name = "id") Long id, @RequestBody Person person) {
        person.setId(id);
        return personRepository.save(person);
    }
    

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable(name = "id") Long id) {
        personRepository.deleteById(id);
    }
}