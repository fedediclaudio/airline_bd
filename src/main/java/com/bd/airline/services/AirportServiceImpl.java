package com.bd.airline.services;

import com.bd.airline.model.*;
import com.bd.airline.repositories.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {


    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private FlightRepository flightRepository;


    @Override
    @Transactional
    public Airplane createAirplane(Airplane airplane) {
        return this.airplaneRepository.save(airplane);
    }

    @Override
    @Transactional
    public Flight createFlight(Flight flight) {
        Flight flight1 = this.flightRepository.save(flight);
        flight.getAirplane().getFlights().add(flight);
        this.airplaneRepository.save(flight.getAirplane());
        return flight1;
    }

    @Override
    @Transactional(readOnly = true)
    public Flight getFlightWithID(ObjectId id) {
        Optional<Flight> flight = this.flightRepository.findById(id);
        return flight.orElse(null);
    }

    @Override
    @Transactional
    public Flight updateFlight(Flight flight) {
        return this.flightRepository.save(flight);
    }

    @Override
    @Transactional
    public Object deleteFlight(Flight flight) {
        try {
            this.flightRepository.delete(flight);
        } catch (Exception e){
            return e;
        }
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public Airplane getAirplaneWithID(ObjectId id) {
        Optional<Airplane> airplane = this.airplaneRepository.findById(id);
        return airplane.orElse(null);
    }

    @Override
    @Transactional
    public Airplane updateAirplane(Airplane airplane) {
        return this.airplaneRepository.save(airplane);
    }

    @Override
    @Transactional
    public boolean deleteAirplane(Airplane airplane) {
        try {
            this.airplaneRepository.deleteById(airplane.getId());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public Flight getFlightWithNumber(long number) {
        return this.flightRepository.findByNumber(number).get(0);
    }

    @Override
    @Transactional
    public List<Flight> getFlightsByAirplaneID(ObjectId id) {
        Optional<Airplane> airplane = this.airplaneRepository.findById(id);
        List<Flight> flights = airplane.isPresent() ? airplane.get().getFlights() : null;
        return flights;
    }
}
