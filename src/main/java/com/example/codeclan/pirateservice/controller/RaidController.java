package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.repository.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/raids")
public class RaidController {

    @Autowired
    RaidRepository raidRepository;

    @GetMapping
    public List<Raid> getAllRaids(){
        return raidRepository.findAll();
    }

    @GetMapping(value = "/location/{location}")
    public List<Raid> findRaidByLocation(@PathVariable String location){
        return raidRepository.findRaidByLocation(location);
    }
}
