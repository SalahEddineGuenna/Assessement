package com.exemple.airxelerateAssessment.controller;

import com.exemple.airxelerateAssessment.entity.Flight;
import com.exemple.airxelerateAssessment.entity.User;
import com.exemple.airxelerateAssessment.service.FlightService;
import com.exemple.airxelerateAssessment.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private UserService userService;

    @Autowired
    private FlightService flightService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }


    @GetMapping({"/flights"})
    @PreAuthorize("hasAnyRole('Admin', 'User')")
    public ResponseEntity<List<Flight>> getAllFlight() {
        List<Flight> flight = flightService.getFlights();
        return ResponseEntity.ok(flight);
    }

    @DeleteMapping("/flight/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/flight/{id}")
    @PreAuthorize("hasAnyRole('Admin', 'User')")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id) throws NotFoundException {
        Flight flight = flightService.getFlight(id);
        return ResponseEntity.ok(flight);
    }

    @PostMapping("flights/create")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.addFlight(flight);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }
}
