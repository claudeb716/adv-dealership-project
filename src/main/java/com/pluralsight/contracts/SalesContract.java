package com.pluralsight.contracts;
import com.pluralsight.product.Vehicle;
import com.pluralsight.dealership.CarDealership;

public class SalesContract extends Contract {
    //Properties
    private double salesTaxAmount;
    private int recordingFee;
    private int processingFee;
    private boolean financeOption;
    //Constructor
    public SalesContract(String email, String name, boolean isSold, double salesTaxAmount, int recordingFee, int processingFee, boolean financeOption) {
        super(email, name, isSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
    }

    @Override
    public double getPrice() {
        return getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getmPayments() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (financeOption) {
            if (getVehicleSold().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }
}
