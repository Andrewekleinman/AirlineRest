package com.in28minutes.rest.webservices.restfulwebservices.Airline;

import java.util.List;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Integer> {
    
        List<Flight> findById(String id);
        List<Flight> findByDepartAndArriveAndDepartDateAndReturnDate(String depart, String arrive, LocalDate deapartDate, LocalDate returnDate);
}

