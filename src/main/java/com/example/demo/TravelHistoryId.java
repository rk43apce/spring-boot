package com.example.demo;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class TravelHistoryId implements Serializable {
    private LocalDate date;
    private String startCity;
    private String endCity;
    private String traveler;

    public TravelHistoryId() {}

    public TravelHistoryId(LocalDate date, String startCity, String endCity, String traveler) {
        this.date = date;
        this.startCity = startCity;
        this.endCity = endCity;
        this.traveler = traveler;
    }

    // Getters and setters
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getStartCity() { return startCity; }
    public void setStartCity(String startCity) { this.startCity = startCity; }
    public String getEndCity() { return endCity; }
    public void setEndCity(String endCity) { this.endCity = endCity; }
    public String getTraveler() { return traveler; }
    public void setTraveler(String traveler) { this.traveler = traveler; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelHistoryId that = (TravelHistoryId) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(startCity, that.startCity) &&
                Objects.equals(endCity, that.endCity) &&
                Objects.equals(traveler, that.traveler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, startCity, endCity, traveler);
    }
}

