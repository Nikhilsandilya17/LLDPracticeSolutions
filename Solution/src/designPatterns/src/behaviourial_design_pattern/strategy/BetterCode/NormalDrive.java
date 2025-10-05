package designPatterns.src.behaviourial_design_pattern.strategy.BetterCode;

public class NormalDrive implements DriveStrategy{


    @Override
    public void drive() {
        System.out.println("This is Normal Drive");
    }
}
