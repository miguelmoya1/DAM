package CompareVehicles;

public class Car extends Vehicle {
    private final double _price;
    private final double _amountOfGasoline;
    
    public Car(double speed, double price, double amountOfGasoline) {
        super(speed, Type.CAR);
        
        this._price = price;
        this._amountOfGasoline = amountOfGasoline;
    }

    @Override
    public double getCostKm() {
        return this._amountOfGasoline * this._price;
    }
    
}
