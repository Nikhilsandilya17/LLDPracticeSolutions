package designPatterns.src.creational_design_pattern.builderSanket;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Segment {
    private String from;
    private String to;
    private LocalDateTime arriveAt;
    private LocalDateTime departAt;
    private String carrier;

    public Segment(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.arriveAt = builder.arriveAt;
        this.departAt = builder.departAt;
        this.carrier = builder.carrier;
    }

    static class Builder{
        private String from;
        private String to;
        private LocalDateTime arriveAt;
        private LocalDateTime departAt;
        private String carrier;

        Builder setFrom(String from){
            if(from!= null && from.length() != 3){
                throw new IllegalArgumentException("From code must be 3 characters long");
            }
            this.from = from;
            return this;
        }

        Builder setTo(String to){
            if(to!=null && to.length() != 3){
                throw new IllegalArgumentException("To code must be 3 characters long");
            }
            this.to = to;
            return this;
        }

        Builder setArriveAt(LocalDateTime arriveAt){
            this.arriveAt = arriveAt;
            return this;
        }

        Builder setDepartAt(LocalDateTime departAt){
            if(this.arriveAt!=null && departAt.isAfter(this.arriveAt)){
                throw new IllegalArgumentException("Departure time cannot be after arrival time");
            }
            this.departAt = departAt;
            return this;
        }

        Builder setCarrier(String carrier){
            this.carrier = carrier;
            return this;
        }

        Segment build(){
            return new Segment(this);
        }
    }

}
