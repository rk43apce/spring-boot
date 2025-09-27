package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {


    @Query(value = "SELECT * FROM travel_history", nativeQuery = true)
    List<Map<String, Object>> findAllRaw();

}



