package behaviourial_design_pattern.strategy.BetterCode;

public class XYZDrive implements DriveStrategy{

    //May be such drive method comes in future
    //So our code is extensible

    @Override
    public void drive() {
        System.out.println("This is future drive method");
    }
}
