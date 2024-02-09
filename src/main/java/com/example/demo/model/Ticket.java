package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;
import java.time.LocalTime;
import java.time.LocalDate;


@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idmovieName;
    private String movieName;
    private Long idcustomer;
    private String customerName;
    private String seatNumber;
    private LocalTime showtime;
    private String Projcetionroom;
    private String phonenumber;
    private String email;
    
   
    private LocalDate date;

    @PrePersist
    protected void onCreate() {
        date = LocalDate.now();
    }

  

    

}