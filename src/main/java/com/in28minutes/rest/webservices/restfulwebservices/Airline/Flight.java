package com.in28minutes.rest.webservices.restfulwebservices.Airline;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Flight {

	public Flight() {
		
	}
	
	public Flight(int id, String depart, String arrive, LocalDate departDate, LocalDate returnDate, boolean[] seats) {
		super();
		this.id = id;
		this.depart = depart;
		this.arrive = arrive;
		this.departDate = departDate;
		this.returnDate=returnDate;
		this.seats = seats;
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

	@Id
	@GeneratedValue
	private int id;

	private String depart;
	
	private String arrive;
	private LocalDate departDate;
	private LocalDate returnDate;
	private boolean[] seats;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



}