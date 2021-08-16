package com.team17.desking.controllers;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import com.team17.desking.entity.Building;
import com.team17.desking.entity.Seat;
import com.team17.desking.entity.User;
import com.team17.desking.repository.BuildingRepository;
import com.team17.desking.repository.SeatRepository;
import com.team17.desking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.team17.desking.entity.Booking;
import com.team17.desking.repository.BookingRepository;

@RestController
public class BookingController {



	@Autowired
	private BookingRepository bookrepo;

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private BuildingRepository buildrepo;

	@Autowired
	private SeatRepository seatrepo;

	@CrossOrigin()
	@GetMapping("/desking/booking/{userId}")	
	public List<Object> getUserBookings(@PathVariable Long userId){
		return bookrepo.getUserBookingsAndSeatInfo(userId);	
	}
	
	@CrossOrigin()
	@PostMapping("/desking/booking/create")
	public Long add(@RequestBody Booking booking) {
		Seat s = seatrepo.getById(booking.getSeatID());
		if(!s.isBooked() && !s.isBlocked()) {
			Booking newBooking = bookrepo.save(booking);
			seatrepo.setSeatBookStatus(s.getSeatId());
	    	return newBooking.getBookingId();
		}
		else return (long) 0;		
	}
	
	@CrossOrigin()
	@DeleteMapping("/desking/booking/{bookingId}")
	public void delete(@PathVariable Long bookingId) {
	    bookrepo.deleteById(bookingId);
	}

	@CrossOrigin()
	@GetMapping("/desking/booking/alldetails")
	public List<Object> getBookingDetailAll()
	{
		return bookrepo.getBookingDetails();
	}

	@CrossOrigin()
	@GetMapping("/desking/getrecommendations/{userId}/{date}")
	public List<Object> getRecommendations(@PathVariable int userId,@PathVariable String date) {

		List<Object> r = new ArrayList<>();

		List<Booking> l = bookrepo.findByDateOfBooking(date);
		User logged_in_user = userrepo.findById((long) userId).orElse(null);
		List<User> u = userrepo.findByTeamId(logged_in_user.getTeamId());

		List<Long> buddies_id = new ArrayList<>();
		for(User us : u) {
			buddies_id.add(us.getUserId());
		}


		for(Booking b: l) {
//	    	System.out.println(buddies_id.contains((long) b.getUserID()));
			if(buddies_id.contains(b.getUserID())) {
				Dictionary<String, Object> recommendations = new Hashtable();

				System.out.println("MATCH FOUNDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD!");
				User u1 = userrepo.findById(b.getUserID()).orElse(null);
				recommendations.put("First Name", u1.getfName());
				recommendations.put("Last Name", u1.getlName());
				Seat seat = seatrepo.findById(b.getSeatID()).orElse(null);
				recommendations.put("Floor",seat.getFloorNo());
				recommendations.put("Seat ID",seat.getSeatId());

				Building build = buildrepo.findById(seat.getBuildingId()).orElse(null);
				recommendations.put("Building", build.getBuildingName());
				recommendations.put("Building ID", build.getBuildingId());

				r.add(recommendations);
			}
		}

		System.out.println("Buddies" + buddies_id);

		return r;
	}
	

}
