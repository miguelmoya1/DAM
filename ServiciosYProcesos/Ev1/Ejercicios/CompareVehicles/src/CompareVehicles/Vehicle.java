package CompareVehicles;

public abstract class Vehicle {
    protected double speed;
    protected Type type;
    
    public Vehicle(double speed, Type type) {
        this.speed = speed;
        this.type = type;                
    }
    
    public static enum Type {
        CAR, BIKE, BUS;
    }

    public double getSpeed() {
        return speed;
    }

    public Type getType() {
        return type;
    }
    
    public abstract double getCostKm();
}
