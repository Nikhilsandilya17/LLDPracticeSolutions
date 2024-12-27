package airlinemanagementsystem.search.impl;

import airlinemanagementsystem.model.Flight;
import airlinemanagementsystem.search.Search;
import airlinemanagementsystem.service.FlightService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SearchImpl implements Search {

    FlightService flightService = new FlightService();

    @Override
    public Flight searchFlight(String source, String destination, String date) {
        if (Objects.isNull(source) || Objects.isNull(destination) || Objects.isNull(date)) {
            throw new IllegalArgumentException("Invalid arguements passed");
        }
        List<Flight> flights = flightService.getAllFlights();
//        List<Flight> returnedFlights = new ArrayList<>();
//        for(Flight flight:flights){
//            if(flight.getDestination().equalsIgnoreCase(destination) && flight.getSource().equalsIgnoreCase(source) && flight.getStartDate().equalsIgnoreCase(date)){
//                returnedFlights.add(flight);
//            }
//
//        }
//        return returnedFlights;

        return flights.stream()
                .filter(flight -> flight.getStartDate().equalsIgnoreCase(date)
                        && destination.equalsIgnoreCase(flight.getDestination())
                        && source.equalsIgnoreCase(flight.getSource()))
                .findFirst()
                .orElse(null);

    }
}
