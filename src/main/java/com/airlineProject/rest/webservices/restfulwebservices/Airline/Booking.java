package com.airlineProject.rest.webservices.restfulwebservices.Airline;

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
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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
    private String departTime;
	public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    private String arriveTime;
	private String price;

    public Booking(String username,int flightId, String depart, String arrive, LocalDate deparDate, int passengers, String bookingType, String departTime, String arriveTime, String price){
        super();
        this.username=username;
        this.flightId=flightId;
        this.depart=depart;
        this.arrive=arrive;
        this.departDate = deparDate;
        this.passengers=passengers;
        this.bookingType=bookingType;
        this.departTime=departTime;
        this.arriveTime=arriveTime;
        this.price=price;
    }
}
