package behaviourial_design_pattern.strategy.ProblematicCode;

public abstract class Vehicle {
    abstract void drive();
}
//Now it can be a case where there are more child which have same drive implementation - Code reusability fails
