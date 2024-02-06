package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.ProjectionRoom1;
import com.example.demo.repository.ProjectionRoom1Repository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/ProjectionRoom1")
public class ProjectionRoom1Controller {

    @Autowired
    private ProjectionRoom1Repository projectionRoom1rojectionRoom1;

    @GetMapping
    public List<ProjectionRoom1> getAllPosters() {
        return projectionRoom1rojectionRoom1.findAll();
    }

    @GetMapping("/{id}")
    public ProjectionRoom1 getProjectionRoom1ById(@PathVariable(name = "id") Long id) {
        return projectionRoom1rojectionRoom1.findById(id).orElse(null);
    }

    @PostMapping
    public ProjectionRoom1 createProjectionRoom1(@RequestBody ProjectionRoom1 projectionRoom1) {
        return projectionRoom1rojectionRoom1.save(projectionRoom1);
    }

    @PutMapping("/{id}")
    public ProjectionRoom1 updateProjectionRoom1(@PathVariable(name = "id") Long id, @RequestBody ProjectionRoom1 projectionRoom1) {
        projectionRoom1.setId(id);
        return projectionRoom1rojectionRoom1.save(projectionRoom1);
    }


    @DeleteMapping("/{id}")
    public void deletePoster(@PathVariable(name = "id") Long id) {
        projectionRoom1rojectionRoom1.deleteById(id);
    }

    
}
