package com.example.demo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "travel_history")
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;

    private LocalDate date;

    private String traveler;

    private String start_city;

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTraveler() {
        return traveler;
    }
    public void setTraveler(String traveler) {
        this.traveler = traveler;
    }
}
