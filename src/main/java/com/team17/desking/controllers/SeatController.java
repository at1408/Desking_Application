package com.team17.desking.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team17.desking.entity.Seat;
import com.team17.desking.repository.SeatRepository;

@RestController
public class SeatController {

	@Autowired
	private SeatRepository seatRepository;
	 
	@PutMapping("desking/seat/block/{seatId}")
	public void blockSeat(@PathVariable Long seatId) {
		try {
			Seat existingSeat = seatRepository.getById(seatId);
			Boolean blockStatus=true;
			if(existingSeat.isBlocked())
				blockStatus=false;
			else
				blockStatus=true;
			seatRepository.setSeatBlockStatus(blockStatus, seatId);
			
		}catch (NoSuchElementException e) {
	        
	    }   
	}
	

}
