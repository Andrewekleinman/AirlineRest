package com.in28minutes.rest.webservices.restfulwebservices.Airline;

import java.util.List;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Integer> {
    
        Flight findById(int id);
        List<Flight> findByDepartAndArriveAndDepartDate(String depart, String arrive, LocalDate deapartDate);
        List<Flight> findByDepart(String depart);
}

