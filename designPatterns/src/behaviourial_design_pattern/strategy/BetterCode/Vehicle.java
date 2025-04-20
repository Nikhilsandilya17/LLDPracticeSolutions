package behaviourial_design_pattern.strategy.BetterCode;

public class Vehicle {
    DriveStrategy driveStrategy;
    //Constructor injection

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }
    public void drive(){
        driveStrategy.drive();
    }
}
