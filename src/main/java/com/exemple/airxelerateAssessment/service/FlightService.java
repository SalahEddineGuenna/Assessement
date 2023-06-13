package com.exemple.airxelerateAssessment.service;

import com.exemple.airxelerateAssessment.entity.Flight;
import com.exemple.airxelerateAssessment.repositories.FlightRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight getFlight(Long id) throws NotFoundException {
        return flightRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Flight not found"));
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
