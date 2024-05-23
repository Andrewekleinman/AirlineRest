package com.in28minutes.rest.webservices.restfulwebservices.Airline;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class FlightService {
	
	private static List<Flight> flights = new ArrayList<>();
	
	private static int flightsCount = 0;
	
	public List<Flight> findFligthsByData(String depart, String arrive, LocalDate departDate, LocalDate arriveDate){
		// Predicate<? super Flight> predicate = 
		// 		flight -> (flight.getDepart().equalsIgnoreCase(depart) &&flight.getArrive().equalsIgnoreCase(arrive)&&
        //         flight.getDepartDate().equals(departDate)&&flight.getArriveDate().equals(arriveDate)) ;
		// return flights.stream().filter(predicate).toList();
        flights.add(new Flight());
        return flights;
	}
	
	public Flight addFlight(String depart, String arrive, LocalDate departDate, LocalDate arriveDate, int seats) {
	    Flight flight = new Flight(++flightsCount,depart,arrive,departDate,arriveDate, new boolean[seats]);
		flights.add(flight);
		return flight;
	}
	
	public void deleteById(int id) {
		Predicate<? super Flight> predicate = flight -> flight.getId() == id;
		flights.removeIf(predicate);
	}

	public Flight findById(int id) {
		Predicate<? super Flight> predicate = flight -> flight.getId() == id;
		Flight flight = flights.stream().filter(predicate).findFirst().get();
		return flight;
	}

	public void updateFlight(Flight flight) {
		deleteById(flight.getId());
		flights.add(flight);
	}
}