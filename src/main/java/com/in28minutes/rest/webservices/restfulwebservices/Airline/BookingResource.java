package com.in28minutes.rest.webservices.restfulwebservices.Airline;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResource {
    private BookingRepository bookingRepository;


    public BookingResource(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }

    @GetMapping("/bookings/{username}/{bookingType}/test")
    public List<Booking> retrievebookings(@PathVariable String username,@PathVariable String bookingType){      
        System.out.println(username + " " + bookingType);
        return bookingRepository.findByUsernameAndBookingType(username, bookingType);
    }
    @PutMapping("/bookings/{bookingId}")
    public Booking alterBooking(@PathVariable int bookingId, @RequestBody Booking booking){
        booking.setBookingId(bookingId);
        bookingRepository.save(booking);
        return booking;
    }
    @PostMapping("/bookings")
    public Booking Createbooking(@RequestBody Booking booking){
        List<Booking> cart = bookingRepository.findByUsernameAndBookingType(booking.getUsername(), booking.getBookingType());
        for(Booking b : cart){
            if(b.getFlightId() == booking.getFlightId()){
                booking.setBookingId(b.getBookingId());
                System.out.println(booking.getPassengers() +" " + b.getPassengers());
                booking.setPassengers(booking.getPassengers()+b.getPassengers());
            }
        }
        
        return bookingRepository.save(booking);
    }
}
