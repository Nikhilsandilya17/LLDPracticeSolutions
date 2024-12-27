package airlinemanagementsystem.service;

import airlinemanagementsystem.model.Flight;

import java.util.List;

public class FlightService {
    List<Flight> flights;

    public void addFlights(Flight flight){
        flights.add(flight);
    }
    public List<Flight> getAllFlights(){
        return flights;
    }

    public void cancelFlight(Flight flight){
        flights.remove(flight);
    }
}
