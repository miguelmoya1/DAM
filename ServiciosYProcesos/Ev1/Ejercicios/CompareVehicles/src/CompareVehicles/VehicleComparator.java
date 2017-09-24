package CompareVehicles;

public class VehicleComparator <T extends Vehicle, R extends Vehicle> {
    private final T v1;
    private final R v2;
    
    public VehicleComparator(T v1, R v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
    
    public void compare() {
        System.out.println(this.v1.type + " vs " + this.v2.type + "!!");
        System.out.println("1st Vehicle (" + 
                this.v1.type + ") -> speed: " + 
                String.format("%.1f", this.v1.speed) + " km/h, cost: " + 
                String.format("%.2f", this.v1.getCostKm()) + " €/km");
        System.out.println("1st Vehicle (" + 
                this.v2.type + ") -> speed: " + 
                String.format("%.1f", this.v2.speed) + " km/h, cost: " + 
                String.format("%.2f", this.v2.getCostKm()) + " €/km");
    }
}
