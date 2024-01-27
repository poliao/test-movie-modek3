package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Poster;
import com.example.demo.repository.PosterRepository;

import java.util.List;

@RestController
@RequestMapping("/posters")
public class PosterController {

    @Autowired
    private PosterRepository posterRepository;

    @GetMapping
    public List<Poster> getAllPosters() {
        return posterRepository.findAll();
    }

    @GetMapping("/{id}")
    public Poster getPosterById(@PathVariable(name = "id") Long id) {
        return posterRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Poster createPoster(@RequestBody Poster poster) {
        return posterRepository.save(poster);
    }

    @PutMapping("/{id}")
    public Poster updatePoster(@PathVariable(name = "id") Long id, @RequestBody Poster poster) {
        poster.setId(id);
        return posterRepository.save(poster);
    }


    @DeleteMapping("/{id}")
    public void deletePoster(@PathVariable(name = "id") Long id) {
        posterRepository.deleteById(id);
    }

    
}
