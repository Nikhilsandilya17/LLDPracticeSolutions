package airlinemanagementsystem.model;

import java.util.Map;

public class Flight {
    int flightId;
    String source;
    Map<Integer, User> seatCapacity; // {flightId, userid}

    public Flight(int flightId, String source, String destination, String startDate) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.startDate = startDate;
    }

    public Map<Integer, User> getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Map<Integer, User> seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    String destination;
    String startDate;
    Map<Booking, Payment> bookingPaymentHistory;
    public static final int TOTAL_SEATS = 30;


}
