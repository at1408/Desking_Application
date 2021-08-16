package com.team17.desking.controllers;

import com.team17.desking.entity.Seat;
import com.team17.desking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
public class DeskingControl {

    @Autowired
    private SeatRepository repository;
    @CrossOrigin()
    @GetMapping("/")
    public String checkStart(){
        return "Hosting is Working Great";
    }

    @CrossOrigin()
    @GetMapping("seats")
    public Iterable<Seat> getSeats() {
        return repository.findAll();
    }
    

    @CrossOrigin
    @GetMapping("desking/buildings/{id}")
    public List<Seat> getSeatsByBuildingId(@PathVariable("id") Long id) {
        return repository.findByBuildingId(id);
    }
    

    @CrossOrigin()
    @PostMapping("seats/add")
    public Seat bookSeat(@RequestBody Seat seat) {
        return repository.save(seat);
    }




}
