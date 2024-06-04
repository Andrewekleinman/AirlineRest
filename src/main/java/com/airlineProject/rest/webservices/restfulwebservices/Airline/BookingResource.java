package com.airlineProject.rest.webservices.restfulwebservices.Airline;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResource {
    private BookingRepository bookingRepository;
    //private FlightRepository flightRepository;

    public BookingResource(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }

    @GetMapping("/bookings/{username}/{bookingType}/test")
    public List<Booking> retrievebookings(@PathVariable String username,@PathVariable String bookingType){    
        List<Booking> list = bookingRepository.findByUsernameAndBookingType(username, bookingType);
        for (Booking b : list) {
            if(b.getDepartDate().isBefore(LocalDate.now())){
                bookingRepository.delete(b);
                //flightRepository.deleteById(b.getFlightId());
                list.remove(b);
            }
        }
        return list;
    }
    @DeleteMapping("/bookings/{bookingId}")
    public void deleteBooking(@PathVariable int bookingId){
        bookingRepository.deleteById(bookingId);;
    }
    @PutMapping("/purchase/{username}")
    public List<Booking> alterBooking(@PathVariable String username){
        List<Booking> list = bookingRepository.findByUsernameAndBookingType(username, "Cart");
        List<Booking> inventory = bookingRepository.findByUsernameAndBookingType(username, "Inventory");
        //System.out.println("reachable code");
        //System.out.println(list.toString());
        boolean duplicate = false;
        for (Booking b : list) {
            for (Booking i : inventory) {
                if(i.getFlightId()==b.getFlightId()){
                    i.setPassengers(i.getPassengers()+b.getPassengers());
                    bookingRepository.delete(b);
                    duplicate=true;
                }
            }
            if(duplicate != true){
                //System.out.println(b.toString());
                b.setBookingType("Inventory");
                bookingRepository.save(b);
            }
        }
        return list;
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
