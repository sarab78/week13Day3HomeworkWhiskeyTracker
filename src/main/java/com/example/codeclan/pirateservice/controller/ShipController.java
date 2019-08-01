package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ships")
public class ShipController {

    @Autowired
    ShipRepository shipRepository;

    @GetMapping
    public List<Ship> getAllShips(){
        return shipRepository.findAll();
    }

    @GetMapping(value = "/pirates/named/{name}")
    public List<Ship> findShipsThatHavePiratesNamed(@PathVariable String name) {
        return shipRepository.findShipsThatHavePiratesNamed(name);

    }

}



