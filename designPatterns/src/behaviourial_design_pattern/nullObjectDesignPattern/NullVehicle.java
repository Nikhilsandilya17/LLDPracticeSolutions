package behaviourial_design_pattern.nullObjectDesignPattern;

public class NullVehicle implements Vehicle{

    @Override
    public int getSeatCapacity() {
        return 0;
    }

    @Override
    public int getTankCapacity() {
        return 0;
    }
}
