package designPatterns.src.behaviourial_design_pattern.strategy.BetterCode;

public class SpecialDrive implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("This is Special drive");
    }
}
