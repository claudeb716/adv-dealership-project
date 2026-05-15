package com.pluralsight.contracts;

import java.io.*;

public class ContractFileManger {

    public void saveContract(Contract contract){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv",true))) {
           // Write Contract information
           if (contract instanceof SalesContract){
             bw.write("SALE " + " | " + contract.getDate() + " | " + contract.getName() + " | " + contract.getEmail() + "\n" +
            contract.getVehicleSold().getVin() + " | " + contract.getVehicleSold().getYear() + " | " + contract.getVehicleSold().getMake() + " | " + contract.getVehicleSold().getModel() + " | " + contract.getVehicleSold().getVehicleType() + " | " +  contract.getVehicleSold().getColor() + " | " + contract.getVehicleSold().getOdometer() + " | " + contract.getVehicleSold().getPrice() + " | " + "\n"
           + ((SalesContract) contract).getSalesTaxAmount() + " | " + ((SalesContract) contract).getRecordingFee() + " | " + ((SalesContract) contract).getProcessingFee() + " | " + contract.getPrice() + " | " + ((SalesContract) contract).isFinanceOption() + " | " + contract.getMonthlyPayments());
           } else if (contract instanceof LeaseContract) {
               bw.write("LEASE " + " | " + contract.getDate() + " | " + contract.getName() + " | " + contract.getEmail() + "\n" +
                       contract.getVehicleSold().getVin() + " | " + contract.getVehicleSold().getYear() + " | " + contract.getVehicleSold().getMake() + " | " + contract.getVehicleSold().getModel() + " | " + contract.getVehicleSold().getVehicleType() + " | " +  contract.getVehicleSold().getColor() + " | " + contract.getVehicleSold().getOdometer() + " | " + contract.getVehicleSold().getPrice() + " | " + "\n"
                       + ((LeaseContract) contract).getExpectedEndingValue() + " | " +  ((LeaseContract) contract).getLeaseFee() + " | " + contract.getPrice() + " | " + contract.getMonthlyPayments());
           }
           bw.newLine();

       } catch (Exception e) {
           System.err.println(" Could not save Contract" + e.getMessage());
       }

    }
}
