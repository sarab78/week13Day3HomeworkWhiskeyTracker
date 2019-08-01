package com.example.codeclan.pirateservice.repository;

import com.example.codeclan.pirateservice.models.Ship;

import java.util.List;

public interface ShipRepositoryCustom {
    //TODO: put method prototype for custom queries in here.

    List<Ship> findShipsThatHavePiratesNamed(String firstName);


}
