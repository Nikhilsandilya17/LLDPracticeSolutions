package designPatterns.src.creational_design_pattern.builder.itineraryBuilderSanket;

import java.time.LocalDateTime;

public class Segment {
    private final String from;
    private final String to;
    private final LocalDateTime arriveAt;
    private final LocalDateTime departAt;
    private final String carrier;

    private Segment(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.arriveAt = builder.arriveAt;
        this.departAt = builder.departAt;
        this.carrier = builder.carrier;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public LocalDateTime getArriveAt() {
        return arriveAt;
    }

    public LocalDateTime getDepartAt() {
        return departAt;
    }

    public String getCarrier() {
        return carrier;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", arriveAt=" + arriveAt +
                ", departAt=" + departAt +
                ", carrier='" + carrier + '\'' +
                '}';
    }

    public static class Builder{
        private String from;
        private String to;
        private LocalDateTime arriveAt;
        private LocalDateTime departAt;
        private String carrier;

        public Builder from(String from){
            if(from!= null && from.length() != 3){
                throw new IllegalArgumentException("From code must be 3 characters long");
            }
            this.from = from;
            return this;
        }

        public Builder to(String to){
            if(to!=null && to.length() != 3){
                throw new IllegalArgumentException("To code must be 3 characters long");
            }
            this.to = to;
            return this;
        }

        public Builder arriveAt(LocalDateTime arriveAt){
            this.arriveAt = arriveAt;
            return this;
        }

        public Builder departAt(LocalDateTime departAt){
            this.departAt = departAt;
            return this;
        }

        public Builder carrier(String carrier){
            this.carrier = carrier;
            return this;
        }

        public Segment build(){
            if (from == null) throw new IllegalStateException("Segment 'from' is required");
            if (to == null) throw new IllegalStateException("Segment 'to' is required");

            if (departAt != null && arriveAt != null) {
                if (arriveAt.isBefore(departAt)) {
                    throw new IllegalStateException("arriveAt must be after departAt");
                }
            }
            return new Segment(this);
        }
    }

}
