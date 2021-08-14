package com.team17.desking.controllers;

import com.team17.desking.entity.Seat;
import com.team17.desking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeskingControl {

    @Autowired
    private SeatRepository repository;
    @GetMapping("/")
    public String checkStart(){
        return "Hosting is Working Great";
    }

    @GetMapping("seats")
    public Iterable<Seat> getSeats() {
        return repository.findAll();
    }

    @GetMapping("desking/buildings/{id}")
    public List<Seat> getSeatsByBuildingId(@PathVariable("id") long id) {
        return repository.findByBuildingId(id);
    }

    @PostMapping("seats/add")
    public Seat bookSeat(@RequestBody Seat seat) {
        return repository.save(seat);
    }




}
