package com.pluralsight.contracts;
import com.pluralsight.product.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Contract {
    //Fields
    private String date;
    private String name;
    private String email;
    private Vehicle vehicleSold;

    //Constructor
    public Contract( String email, String name, Vehicle vehicleSold) {
        this.date = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        this.email = email;
        this.name = name;
        this.vehicleSold = vehicleSold;

    }
    //Getters

    public String getDate() {
        return this.date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }
    //Setters

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void vehicleSold (Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    //Abstract Methods
    public abstract double getPrice();
    public abstract double getMonthlyPayments();
}
