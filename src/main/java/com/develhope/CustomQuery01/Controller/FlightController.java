package com.develhope.CustomQuery01.Controller;

import com.develhope.CustomQuery01.Entities.Flight;
import com.develhope.CustomQuery01.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@RestController
@RequestMapping("/flights")
public class FlightController {

    private static final int NUM_FLIGHTS = 50;

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public List<Flight> getAllFlights() {
        return (List<Flight>) flightRepository.findAll();
    }

    @PostMapping("/provision")
    public List<Flight> provisionFlights() {
        Random random = new Random();
        List<Flight> flights = new ArrayList<>();
        for (int i = 0; i < NUM_FLIGHTS; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight #" + i);
            flight.setFromAirport("Airport " + random.nextInt(10));
            flight.setToAirport("Airport " + random.nextInt(10));
            flights.add(flight);
        }
        return (List<Flight>) flightRepository.saveAll(flights);
    }
}
