package airlinemanagementsystem;

import airlinemanagementsystem.model.Flight;
import airlinemanagementsystem.model.User;
import airlinemanagementsystem.service.FlightService;
import airlinemanagementsystem.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirlineManagementSystemDemo {

    public static void main(String[] args){

        FlightService flightService = new FlightService();
        Flight flight1 = new Flight(1, "DEL", "BLR", "26/12/2024");
        flightService.addFlights(flight1);
        Flight flight2 = new Flight(2, "IDR", "AGR", "27/12/2024");
        flightService.addFlights(flight2);
        Flight flight3 = new Flight(3, "PAT", "TAN", "28/12/2024");
        flightService.addFlights(flight3);
        Flight flight4 = new Flight(4, "DEL", "PJB", "26/12/2024");
        flightService.addFlights(flight4);
        Flight flight5 = new Flight(5, "BLR", "IDR", "26/12/2024");
        flightService.addFlights(flight5);

        User user = new User(1, "Nikhil");
        UserService userService = new UserService();
        boolean bookingStatus = userService.bookFlights("DEL", "BLR", "26/12/2024", user);
        if(bookingStatus == true){
            System.out.println("Booking confirmed");
        }





    }
}
