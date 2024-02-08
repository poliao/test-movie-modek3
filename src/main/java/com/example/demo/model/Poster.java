package com.example.demo.model;


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
    private String showtime;
    private String endtime; //วันที่ฉาย
    private String catagory;
    private String Audiencerating; //เรทผู้ชม
    private String Director;
    private List<String> time;
    private String Logtime; //ระยะเวลา
    private List<String> Projcetionroom;

    // constructors, getters, setters
}
