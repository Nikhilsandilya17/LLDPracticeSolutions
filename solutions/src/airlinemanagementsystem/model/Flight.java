package airlinemanagementsystem.model;

public class Flight {
    int flightId;
    String source;

    public Flight(int flightId, String source, String destination, String startDate) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.startDate = startDate;
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

}
