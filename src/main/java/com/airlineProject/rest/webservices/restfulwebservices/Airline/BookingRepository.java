package com.airlineProject.rest.webservices.restfulwebservices.Airline;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

    
public interface BookingRepository extends JpaRepository<Booking,Integer>{
    List<Booking> findByUsername(String username);
    List<Booking> findByUsernameAndBookingType(String username, String bookingType);
    Booking findById(int id);
}
