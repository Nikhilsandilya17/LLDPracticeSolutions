package behaviourial_design_pattern.nullObjectDesignPattern;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType) {
        if(vehicleType.equalsIgnoreCase("CAR")){
            return new Car();
        } else {
            return new NullVehicle();
        }
    }
}
