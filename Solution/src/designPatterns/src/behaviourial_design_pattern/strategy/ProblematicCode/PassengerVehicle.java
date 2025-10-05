package designPatterns.src.behaviourial_design_pattern.strategy.ProblematicCode;

public class PassengerVehicle extends Vehicle{

    @Override
    void drive() {
        System.out.println("Normal drive method");
    }
}
//Now it can be a case where there are more child which have same drive implementation - Code reusability fails
