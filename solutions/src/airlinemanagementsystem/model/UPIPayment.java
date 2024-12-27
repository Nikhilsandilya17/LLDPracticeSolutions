package airlinemanagementsystem.model;

import airlinemanagementsystem.enums.SeatType;

import java.util.Objects;

public class UPIPayment extends Payment{

    @Override
    public void processPayment(SeatType seatType) {
        System.out.println("Processing payment for " + seatType + " seat...");

        if (Objects.equals(SeatType.VIP, seatType)) {
            System.out.println("VIP seat price is higher. Processing...");
        } else {
            System.out.println("Regular seat price is standard. Processing...");
        }
    }
}
