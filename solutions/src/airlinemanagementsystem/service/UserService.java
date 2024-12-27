package airlinemanagementsystem.service;

import airlinemanagementsystem.enums.PaymentMode;
import airlinemanagementsystem.enums.SeatType;
import airlinemanagementsystem.model.Flight;
import airlinemanagementsystem.model.Payment;
import airlinemanagementsystem.model.UPIPayment;
import airlinemanagementsystem.model.User;
import airlinemanagementsystem.search.Search;

import java.util.Map;
import java.util.Objects;

import static airlinemanagementsystem.enums.SeatType.VIP;

public class UserService {

    private Search search;

    public boolean bookFlights(String source, String destination, String date, User user) {
        Flight flight = search.searchFlight(source, destination, date);
        if (Objects.isNull(flight)) {
            System.out.println("No flights available");
            return false;
        }
        Map<Integer, User> seatCapacity = flight.getSeatCapacity();

        return checkSeatAvailability(seatCapacity, flight, user);
    }

    private void removeSeats(Flight flight, Map<Integer, User> seatCapacity) {
        seatCapacity.remove(flight.getFlightId());
    }

    private boolean checkSeatAvailability(Map<Integer, User> seatCapacity, Flight flight, User user) {
        if (seatCapacity.size() >= Flight.TOTAL_SEATS) {
            System.out.println("No available seats. Booking failed.");
            return false;
        }

        int filledSeats = seatCapacity.size();
        SeatType seatType = (filledSeats <= 3) ? SeatType.REGULAR : VIP;
        seatCapacity.put(flight.getFlightId(), user);
        if (processPayment(seatType)) {
            System.out.println("Payment successful. Booking confirmed for user: " + user.getName());
            return true;
        } else {
            System.out.println("Payment failed. Booking could not be completed.");
            removeSeats(flight, seatCapacity);
            return false;
        }
    }

    private boolean processPayment(SeatType seatType) {
        Payment payment = new UPIPayment();
        payment.setPaymentId(generatePaymentId());
        payment.setPaymentMode(selectPaymentMode());
        payment.processPayment(seatType);
        return true;
    }

    private PaymentMode selectPaymentMode() {
        System.out.println("Selecting payment mode...");
        return PaymentMode.UPI;
    }

    private int generatePaymentId() {
        return (int) (Math.random() * 100000);
    }
}
