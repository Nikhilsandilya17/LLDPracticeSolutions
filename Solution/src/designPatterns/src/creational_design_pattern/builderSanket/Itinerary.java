package designPatterns.src.creational_design_pattern.builderSanket;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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
        this.tags = (builder.segments == null) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(builder.tags));
        this.segments = (builder.segments == null) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(builder.segments));

    }

    @Override
    public String toString() {
        return "Itinerary{" + "travellerName='" + travellerName + '\'' + ", startDate=" + startDate + ", endDate=" + endDate + ", origin='" + origin + '\'' + ", destination='" + destination + '\'' + ", segments=" + segments + ", budget=" + budget + ", travelInsurance=" + travelInsurance + ", tags=" + tags + '}';
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

        public Builder travellerName(String travellerName) {
            if (travellerName == null || travellerName.isEmpty()) {
                throw new IllegalArgumentException("Traveller name cannot be null or empty");
            }
            this.travellerName = travellerName;
            return this;
        }

        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            if (startDate != null && endDate.isBefore(this.startDate)) {
                throw new IllegalArgumentException("End date cannot be before start date");
            }
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

        public Builder segments(List<Segment> segments) {
            this.segments = segments;
            return this;
        }

        public Builder budget(Budget budget) {
            this.budget = budget;
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
