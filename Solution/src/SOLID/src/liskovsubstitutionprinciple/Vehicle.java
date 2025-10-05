package SOLID.src.liskovsubstitutionprinciple;

public abstract class Vehicle {
     Boolean hasEngine(){
         return true;
     }
     void getNumberOfWheels(){
         System.out.println("2");
     }
}
