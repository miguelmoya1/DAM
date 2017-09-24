package CompareVehicles;

public class Bike extends Vehicle {

    public Bike(double speed) {
        super(speed, Type.BIKE);
    }
    
    @Override
    public double getCostKm() {
        return 0;
    }
}
