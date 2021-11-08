package com.bd.airline.repositories;

import com.bd.airline.model.Flight;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends MongoRepository<Flight, ObjectId> {

    public List<Flight> findByNumber(long aNumber);
}
