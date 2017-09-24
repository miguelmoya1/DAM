package CompareVehicles;

public class Bus extends Vehicle {
    private double _ticketPrice;
    private double _distanceCover;

    public Bus(double speed, double ticketPrice, double distanceCover) {
        super(speed, Type.BUS);
        
        this._ticketPrice = ticketPrice;
        this._distanceCover = distanceCover;
    }

    @Override
    public double getCostKm(double money) {
        return this._ticketPrice / this._distanceCover;
    }
}
