package com.team17.desking.repository;

import java.util.List;

import com.team17.desking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team17.desking.entity.Booking;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<Booking, Long> {


//	@Query("SELECT book FROM booking book WHERE book.userID=?1")
//	public List<Booking> getUserBookings(Long userId);
//	@Query("select u.email from user u join booking b on u.userId = b.userID where TIMESTAMPDIFF(DAY,b.dateOfBooking,NOW()) = 1")
//	public List<String> getUserEmails();
	
	@Query("SELECT s,b from seat s join booking b on s.seatId = b.seatID where b.userID=?1")
	public List<Object> getUserBookingsAndSeatInfo(Long userId);
	

	@Query("SELECT book FROM booking book WHERE book.userID=?1")
	public List<Booking> getUserBookings(Long userId);

	@Query("select u from user u join booking b on u.userId = b.userID where TIMESTAMPDIFF(DAY,b.dateOfBooking,NOW()) = 0")
	public List<User> getUsers();
	
	@Query("select s.booked from seat s where s.seatId=?1")
   	Boolean checkBookedStatus(Long seat_id);

	@Query("from booking where date_of_booking like :d%")
	List<Booking> findByDateOfBooking(@Param("d") String d);
	
	@Query("select u.userId, u.fName, u.lName, u.email, b.bookingId, b.dateOfBooking, b.seatID, s.floorNo, s.buildingId from user u join booking b on u.userId=b.userID join seat s on s.seatId=b.seatID")
	public List<Object> getBookingDetails();


}
