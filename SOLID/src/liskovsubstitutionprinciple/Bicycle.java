package liskovsubstitutionprinciple;

public class Bicycle extends Vehicle {
    @Override
    Boolean hasEngine(){
        System.out.println("Parent class method has been overridden in Bicycle class");
        return null;
    }
}
