package com.airlineProject.rest.webservices.restfulwebservices.Airline;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Flight {

	public Flight() {
		
	}

	@Id
	@GeneratedValue
	private int id;

	private String depart;	
	private String arrive;
	private LocalDate departDate;
	private LocalDate returnDate;
	private boolean[] seats;
	private int flightsRemaining;
	private String departTime;
	private String arriveTime;
	private String price;

	// public Flight(int id, String depart, String arrive, LocalDate departDate, LocalDate returnDate, int flightsRemaining ) {
	// 	super();
	// 	this.id = id;
	// 	this.depart = depart;
	// 	this.arrive = arrive;
	// 	this.departDate = departDate;
	// 	this.returnDate=returnDate;
	// 	this.flightsRemaining = flightsRemaining;
	// }
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
	public Flight(int id, String depart, String arrive, LocalDate departDate, LocalDate returnDate, int flightsRemaining , String departTime, String arriveTime, String price) {
		super();
		this.id = id;
		this.depart = depart;
		this.arrive = arrive;
		this.departDate = departDate;
		this.returnDate=returnDate;
		this.flightsRemaining = flightsRemaining;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
		this.price = price;
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
	public int getFlightsRemaining() {

		
		return flightsRemaining;
	}

	public void setFlightsRemaining(int flightsRemaining) {

		this.flightsRemaining=flightsRemaining;
	}
	public LocalDate getDepartDate() {
		return departDate;
	}

	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public boolean[] getSeats() {
		return seats;
	}

	public void setSeats(boolean[] seats) {
		this.seats = seats;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



}