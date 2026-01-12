package designPatterns.src.creational_design_pattern.itineraryBuilderSanket;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ItineraryDemo {
    public static void main(String[] args) {
        Segment flight1 = new Segment.Builder()
                .from("BLR")
                .to("DXB")
                .departAt(LocalDateTime.now())
                .arriveAt(LocalDateTime.now().plusHours(1))
                .carrier("Air India")
                .build();

        try {
            Itinerary itinerary = Itinerary.builder()
                    .destination("LHR")
                    .origin("BLR")
                    .startDate(LocalDate.now())
                    .endDate(LocalDate.now().plusWeeks(1))
                    .travellerName("Nikhil")
                    .travelInsurance(true)
                    .budget(2000.0, "USD")
                    .addSegment(flight1)
                    .tags("Vacation")
                    .build();

            System.out.println("Itinerary created successfully:" + itinerary.toString()) ;
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Failed to create Itinerary: Missing required fields." + e.getMessage());
        }

        Itinerary.Builder builder = Itinerary.weekendGetAway("NYC", "BOS")
                .travelInsurance(false)
                .travellerName("Nikhil");

        Itinerary weekendItinerary = builder.build();
        System.out.println("Weekend Itinerary created successfully:" + weekendItinerary.toString());

    }
}
