package com.example.demo.controller;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/Person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable(name = "id") Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Person person) {
        // เช็คการยืนยันตัวตนของผู้ใช้
        if (authenticationService.authenticate(person.getEmail(), person.getPassword())) {
            String token = tokenService.generateToken(person.getEmail());
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable(name = "id") Long id, @RequestBody Person person) {
        person.setId(id);
        return personRepository.save(person);
    }
    

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable(name = "id") Long id) {
        personRepository.deleteById(id);
    }
}