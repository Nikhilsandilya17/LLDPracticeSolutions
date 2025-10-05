package designPatterns.src.behaviourial_design_pattern.strategy.BetterCode;

public class StrategyDemo {
    public static void main(String[] args) {
        Vehicle normalVehicle = new Vehicle(new NormalDrive());
        normalVehicle.drive();
        Vehicle specialVehicle = new Vehicle(new SpecialDrive());
        specialVehicle.drive();
        Vehicle xyzVehicle = new Vehicle(new XYZDrive());
        xyzVehicle.drive();


    }
}
