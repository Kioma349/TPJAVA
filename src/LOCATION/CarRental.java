package LOCATION;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CarRental {

    private List<Vehicle> vehicles;

    public CarRental() {
        vehicles = new ArrayList<>();
    }

    public void add(Vehicle vehicle) {
        Objects.requireNonNull(vehicle);
        vehicles.add(vehicle);
    }

    public void remove(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            throw new IllegalStateException("Vehicle not found");
        }
        vehicles.remove(vehicle);
    }

    public List<Vehicle> toSell() {
        int currentYear = LocalDate.now().getYear();
        List<Vehicle> toSell = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getAge(currentYear) >= vehicle.getSellThreshold()) {
                toSell.add(vehicle);
            }
        }
        return toSell;
    }

    public Optional<Vehicle> findACarByModel(String model) {
        return vehicles.stream()
                .filter(v -> v.getModel().equalsIgnoreCase(model))
                .findFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vehicle vehicle : vehicles) {
            sb.append(vehicle).append("\n");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
