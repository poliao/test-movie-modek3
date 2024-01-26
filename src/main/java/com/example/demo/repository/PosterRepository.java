package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Poster;

public interface PosterRepository extends JpaRepository<Poster, Long> {
    // เพิ่ม method ตามต้องการ
}

