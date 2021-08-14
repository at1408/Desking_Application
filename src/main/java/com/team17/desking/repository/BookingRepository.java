package com.team17.desking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team17.desking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

	@Query("SELECT book FROM booking book WHERE book.userID=?1")
	public List<Booking> getUserBookings(Long userId);
	@Query("select u.email from user u join booking b on u.userId = b.userID where TIMESTAMPDIFF(DAY,b.dateOfBooking,NOW()) < 1")
	public List<String> getUserEmails();

}
