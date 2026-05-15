package com.pluralsight.contracts;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Contract {
    //Fields
    private String date;
    private String name;
    private String email;
    private boolean isSold;
    private double price;
    private double mPayments;
    //Constructor
    public Contract( String email, String name, boolean isSold,double price, double mPayments) {
        this.date = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        this.email = email;
        this.name = name;
        this.isSold = isSold;
        this.price = price;
        this.mPayments = mPayments;
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

    public boolean isSold() {
        return isSold;
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

    public void setSold(boolean sold) {
        this.isSold = sold;
    }

    //Abstract Methods
    public abstract double getPrice();
    public abstract double getmPayments();
}
