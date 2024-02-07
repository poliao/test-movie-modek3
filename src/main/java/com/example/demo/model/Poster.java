package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "poster")
public class Poster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imgPoster;
    private String backgroundPoster;
    @Column(length = 10000)
    private String detail;
    private String nameMovie;
    private LocalDateTime showtime;
    private LocalDateTime endtime; //วันที่ฉาย
    private String catagory;
    private String Audiencerating; //เรทผู้ชม
    private String Director;
    private List<Long> time;
    private List<String> Projcetionroom;

    // constructors, getters, setters
}
