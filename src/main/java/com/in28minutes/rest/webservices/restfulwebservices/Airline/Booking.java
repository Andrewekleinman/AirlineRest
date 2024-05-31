package com.in28minutes.rest.webservices.restfulwebservices.Airline;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Booking {
    public Booking() {
		
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public LocalDate getDepartDate() {
        return departDate;
    }

    public void setDepartDate(LocalDate departDate) {
        this.departDate = departDate;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
	@Id
	@GeneratedValue
    private int bookingId;
    private String username;
    private int flightId;
	private String depart;	
	private String arrive;
	private LocalDate departDate;
	private int passengers;
    private String bookingType; //cart or inventory

    public Booking(String username,int flightId, String depart, String arrive, LocalDate deparDate, int passengers, String bookingType){
        super();
        this.username=username;
        this.flightId=flightId;
        this.depart=depart;
        this.arrive=arrive;
        this.departDate = deparDate;
        this.passengers=passengers;
        this.bookingType=bookingType;
    }
}
