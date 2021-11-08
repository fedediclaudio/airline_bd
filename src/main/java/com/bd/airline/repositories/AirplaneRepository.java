package com.bd.airline.repositories;

import com.bd.airline.model.Airplane;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends MongoRepository<Airplane, ObjectId> {
}
