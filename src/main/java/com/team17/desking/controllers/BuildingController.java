package com.team17.desking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team17.desking.entity.Building;
import com.team17.desking.entity.Seat;
import com.team17.desking.repository.BuildingRepository;

@RestController
public class BuildingController {

    @Autowired
    private BuildingRepository repository;

    @GetMapping("desking/buildings")
    public List<Building> getBuildings() {
        return repository.findAll();
    }

    @PostMapping("desking/buildings/add")
    public Building addBuilding(@RequestBody Building building) {
        repository.save(building);
        return building;
    }




}

