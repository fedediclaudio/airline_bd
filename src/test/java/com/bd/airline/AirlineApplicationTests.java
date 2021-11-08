package com.bd.airline;

import com.bd.airline.model.Airplane;
import com.bd.airline.model.Flight;
import com.bd.airline.model.Route;
import com.bd.airline.services.AirportService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class AirlineApplicationTests {

	@Autowired
	AirportService service;

	@Test
	void contextLoads() {
	}

	@Test
	void prueba() {
		System.out.println("OK!");
	}

	@Test
	void createAirplane () {
		Airplane airplane = new Airplane("Boeing", "747", "069-89694876311", 3, 250);
		this.service.createAirplane(airplane);
	}

	@Test
	void creationFlight(){
		Airplane airplane = new Airplane("Boeing", "747", "069-89694876311", 3, 250);
		airplane = this.service.createAirplane(airplane);
		Flight flight = new Flight(300, Calendar.getInstance().getTime(), 60, airplane, null, null);
		flight = this.service.createFlight(flight);
	}

	@Test
	void getFlight() {
		Flight flight = this.service.getFlightWithID(new ObjectId("61858b5355555841865745d3"));
	}

	@Test
	void getAirplane(){
		Airplane airplane = this.service.getAirplaneWithID(new ObjectId("61858b5355555841865745d3"));
	}

	@Test
	void deleteAirplane() {
		this.service.deleteAirplane(this.service.getAirplaneWithID(new ObjectId("61858b5355555841865745d3 ")));
	}

	@Test
	void updateAirplane(){
		Airplane airplane = this.service.getAirplaneWithID(new ObjectId("61858b5355555841865745d3"));
		airplane.setNumberOfSeats(300);
		this.service.updateAirplane(airplane);
	}


}
