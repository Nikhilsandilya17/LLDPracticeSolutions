package designPatterns.src.creational_design_pattern.builderSanket;

import java.time.LocalDate;

public class ItineraryDemo {
    public static void main(String[] args) {
        Itinerary itinerary = new Itinerary.Builder()
                .destination("IDR")
                .origin("BLR")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusWeeks(1))
                .travellerName("Nikhil")
                .build();
    }
}
