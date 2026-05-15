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
    public SalesContract(String email, String name, boolean isSold, double price, double mPayments, double salesTaxAmount, int recordingFee, int processingFee, boolean financeOption) {
        super(email, name, isSold, price, mPayments);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
    }
//Getters and Setters
    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(int recordingFee) {
        this.recordingFee = recordingFee;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    @Override
    public double getPrice() {
        return getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    private Vehicle getVehicleSold() {
            return null;
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
