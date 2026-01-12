package designPatterns.src.creational_design_pattern.itineraryBuilderSanket;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Itinerary {
    private final String travellerName;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String origin;
    private final String destination;
    private final List<Segment> segments;
    private final Budget budget;
    private final boolean travelInsurance;
    private final List<String> tags;

    private Itinerary(Builder builder) {
        this.travellerName = builder.travellerName;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.origin = builder.origin;
        this.destination = builder.destination;
        this.budget = builder.budget;
        this.travelInsurance = builder.travelInsurance;
        this.segments = (builder.segments == null) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(builder.segments)); //this is defensive on build
        this.tags = (builder.tags == null) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(builder.tags));

    }

    @Override
    public String toString() {
        return "Itinerary{" + "travellerName='" + travellerName + '\'' + ", startDate=" + startDate + ", endDate=" + endDate + ", origin='" + origin + '\'' + ", destination='" + destination + '\'' + ", addSegment=" + segments.toString() + ", budget=" + budget + ", travelInsurance=" + travelInsurance + ", tags=" + tags + '}';
    }

    public static Builder weekendGetAway(String origin, String destination){
        LocalDate nextSaturday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        return new Builder()
                .origin(origin)
                .destination(destination)
                .startDate(nextSaturday)
                .endDate(nextSaturday.plusDays(2))
                .tags("weekend");

    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String travellerName;
        private LocalDate startDate;
        private LocalDate endDate;
        private String origin;
        private String destination;
        private List<Segment> segments = new ArrayList<>();
        private Budget budget;
        private boolean travelInsurance = false;
        private List<String> tags = new ArrayList<>();

        public Builder segments(List<Segment> segments){
            this.segments = new ArrayList<>(segments); //this is called defensive on copy
            /**
             * so that if someone tries to modify the list after passing it to us, it won't affect builder internal state
             */
            return this;
        }

        public Builder travellerName(String travellerName) {
            this.travellerName = travellerName;
            return this;
        }

        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder origin(String origin) {
            if (origin != null && origin.length() != 3) {
                throw new IllegalArgumentException("Origin code must be 3 characters long");
            }
            this.origin = origin;
            return this;
        }

        public Builder destination(String destination) {
            if (destination != null && destination.length() != 3) {
                throw new IllegalArgumentException("Destination code must be 3 characters long");
            }
            this.destination = destination;
            return this;
        }

        public Builder addSegment(Segment segment) {
            this.segments.add(segment);
            return this;
        }

        public Builder tags(String tag) {
            this.tags.add(tag);
            return this;
        }

        public Builder budget(double amount, String currency) {
            this.budget = new Budget(currency, amount);
            return this;
        }

        public Builder travelInsurance(boolean travelInsurance) {
            this.travelInsurance = travelInsurance;
            return this;
        }

        public Itinerary build() {
            List<String> errors = new ArrayList<>();
            if (travellerName == null || travellerName.trim().isEmpty()) {
                errors.add("travelerName is required");
            }
            if (origin == null) errors.add("origin is required");
            if (destination == null) errors.add("destination is required");
            if (startDate == null) errors.add("startDate is required");
            if (endDate == null) errors.add("endDate is required");
            if (startDate != null && endDate != null) {
                if (endDate.isBefore(startDate)) {
                    errors.add("endDate " + endDate + " is before startDate " + startDate);
                }
            }
            if(!errors.isEmpty()){
                throw new IllegalStateException("Cannot create Itinerary, missing or invalid fields: " + String.join(", ", errors));
            }
            return new Itinerary(this);
        }
    }


}
