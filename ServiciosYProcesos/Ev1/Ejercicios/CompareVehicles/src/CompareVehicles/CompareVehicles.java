
package CompareVehicles;

public class CompareVehicles {

    public static void main(String[] args) {
        VehicleComparator<Car, Bus> vehicleComparator = new VehicleComparator<>(
        new Car(120, .2, .3), new Bus(80, 1.45, 80));
        VehicleComparator<Car, Bike> vehicleComparator2 = new VehicleComparator<>(
                new Car(120, .2, .3), new Bike(80));
        
        vehicleComparator.compare();
        vehicleComparator2.compare();
    }
}