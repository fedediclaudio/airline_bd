package com.bd.airline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document
public class Airplane {

    @MongoId
    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId id;

    @Field
    private String mark;

    @Field
    private String model;

    @Field
    private String numberOfRegistration;

    @Field
    private int yearsInService;

    @Field
    private int numberOfSeats;

    @DBRef
    private List<Flight> flights;

    @Version
    private int version;

    public Airplane(){
    }

    public Airplane(String mark, String model, String numberOfRegistration, int yearsInService, int numberOfSeats){
        this.mark = mark;
        this.model = model;
        this.numberOfRegistration = numberOfRegistration;
        this.yearsInService = yearsInService;
        this.numberOfSeats = numberOfSeats;
        this.flights = new ArrayList<Flight>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberOfRegistration() {
        return numberOfRegistration;
    }

    public void setNumberOfRegistration(String numberOfRegistration) {
        this.numberOfRegistration = numberOfRegistration;
    }

    public int getYearsInService() {
        return yearsInService;
    }

    public void setYearsInService(int yearsInService) {
        this.yearsInService = yearsInService;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
