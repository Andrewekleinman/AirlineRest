package com.in28minutes.rest.webservices.restfulwebservices.Airline;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class FlightResource{
    private FlightRepository flightRepository;


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public FlightResource(FlightRepository flightRepository){
        this.flightRepository=flightRepository;
    }

    @GetMapping("/flights/{depart}/{arrive}/{departDate}/test")
    public List<Flight> retrieveFlights(@PathVariable String depart,@PathVariable String arrive,
    @PathVariable String departDate){      
        //return flightRepository.findByDepart(depart);
        return flightRepository.findByDepartAndArriveAndDepartDate(depart, arrive, LocalDate.parse(departDate, formatter));
    }
    @GetMapping("/flights/{id}")
    public Flight retrieveFlight(@PathVariable int id){
        return flightRepository.findById(id);
    }
    @DeleteMapping("/flights/{id}")
    public ResponseEntity<Void> DeleteFlight(@PathVariable int id){
        flightRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/flights/{id}")
    public Flight alterFlight(@PathVariable int id, @RequestBody Flight flight){
        flight.setId(id);
        flightRepository.save(flight);
        return flight;
    }
    @PostMapping("/flights")
    public Flight CreateFlight(@RequestBody Flight flight){
        return flightRepository.save(flight);
        // return flightService.addFlight(flight.getDepart(), flight.getArrive(), flight.getDepartDate(),flight.getReturnDate(), 10);
    }
}