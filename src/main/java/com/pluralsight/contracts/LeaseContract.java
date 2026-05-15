package com.pluralsight.contracts;
import com.pluralsight.product.Vehicle;

public class LeaseContract extends Contract{
    //Properties
    private double expectedEndingValue;
    private double leaseFee;
    //Constructor

    public LeaseContract(String email, String name, boolean isSold, double price, double mPayments, double expectedEndingValue, double leaseFee) {
        super(email, name, isSold, price, mPayments);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }
    //Getters and Setters
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getPrice() {
        return (getVehicleSold().getPrice() - expectedEndingValue) + leaseFee;
    }

    private Vehicle getVehicleSold() {
        return null;
    }

    @Override
    public double getmPayments() {
        int numberOfPayments = 36;
        double interestRate = 4.0 / 1200;
        double monthlyPayment = getPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }
}
