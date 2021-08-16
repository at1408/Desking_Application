package com.team17.desking.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="booking")
public class Booking {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private long bookingId;
	
	@Column
	private long userID;
	
	@Column
	private long seatID;
	
	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="UTC")
	private Timestamp dateOfBooking;
	

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Booking(long userID, long seatID, Timestamp dateOfBooking) {
		super();
		this.userID = userID;
		this.seatID = seatID;
		this.dateOfBooking = dateOfBooking;
	}



	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getSeatID() {
		return seatID;
	}

	public void setSeatID(long seatID) {
		this.seatID = seatID;
	}

	public Timestamp getdateOfBooking() {
		return dateOfBooking;
	}

	public void setdateOfBooking(Timestamp dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userID=" + userID + ", seatID=" + seatID + ", DateOfBooking="
				+ dateOfBooking + "]";
	}
	
	
	

}
