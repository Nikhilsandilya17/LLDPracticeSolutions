package behaviourial_design_pattern.nullObjectDesignPattern;

public class NullObjectDemo {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle("CAR");
        printVehicleDetails(car);
        Vehicle bike = VehicleFactory.getVehicle("BIKE");
        printVehicleDetails(bike);
    }

    private static void printVehicleDetails(Vehicle vehicle) {
        System.out.println(vehicle.getSeatCapacity());
        System.out.println(vehicle.getTankCapacity());
    }
}
