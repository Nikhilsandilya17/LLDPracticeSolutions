package liskovsubstitutionprinciple;

public class Car extends Vehicle {
    @Override
    void getNumberOfWheels(){
        System.out.println("4");
    }

}

