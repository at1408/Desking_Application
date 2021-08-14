package com.team17.desking.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team17.desking.entity.Booking;
import com.team17.desking.repository.BookingRepository;

@RestController
public class BookingController {

	@Autowired
	private BookingRepository bookingRepository;
	
	@GetMapping("/desking/booking/{userId}")	
	public List<Booking> getUserBookings(@PathVariable Long userId){
		return bookingRepository.getUserBookings(userId);	
	}
	
	@PostMapping("/desking/booking/create")
	public Long add(@RequestBody Booking booking) {
	    Booking newBooking = bookingRepository.save(booking);
	    return newBooking.getBookingId();
	}
	
	@DeleteMapping("/desking/booking/{bookingId}")
	public void delete(@PathVariable Long bookingId) {
	    bookingRepository.deleteById(bookingId);
	}
	
	

}
