package SOLID.src.liskovsubstitutionprinciple;

import java.time.Year;

public class LSPDemo {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.getNumberOfWheels();
        Boolean b = vehicle.hasEngine();
        System.out.println(b.booleanValue());

        vehicle = new Bicycle(); // Run time polymorphism
        vehicle.getNumberOfWheels();
        vehicle.hasEngine();
        //vehicle.hasEngine().toString(); -> will throw NPE
    }
}