package com.bd.airline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.stereotype.Indexed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class Flight {

    @MongoId
    @JsonSerialize(using=ToStringSerializer.class)
    private ObjectId id;

    @Field
    private Long number;

    @Field
    private Date dateOfFlight;

    @Field
    private float weightLimit;

    @Field
    private int reservedSeats;

    @DBRef
    private Airplane airplane;

    @BsonIgnore
    private List<Reservation> reservations;

    @BsonIgnore
    private Route route;

    @BsonIgnore
    private Pilot pilot;

    @Version
    private int version;

    public Flight(){}

    public Flight(long number, Date dateOfFlight, float weightLimit, Airplane airplane, Route route, Pilot pilot){
        this.number = number;
        this.dateOfFlight = dateOfFlight;
        this.weightLimit = weightLimit;
        this.airplane = airplane;
        this.route = route;
        this.pilot = pilot;
        this.reservedSeats = 0;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(Date dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public float getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(float weightLimit) {
        this.weightLimit = weightLimit;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
