package LOCATION;


public class Vehicle {
    private String model;
    private int fabricationYear;

    public Vehicle(String model, int fabricationYear) {
        this.model = model;
        this.fabricationYear = fabricationYear;
    }

    public String getModel() {
        return model;
    }

    public int getFabricationYear() {
        return fabricationYear;
    }

    public int getAge(int currentYear) {
        return currentYear - fabricationYear;
    }

    public int getSellThreshold() {
        return 0;
    }

    @Override
    public String toString() {
        return model + " " + fabricationYear;
    }
}

