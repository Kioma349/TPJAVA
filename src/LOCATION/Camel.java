package LOCATION;


public class Camel extends Vehicle {

    public Camel(int fabricationYear) {
        super("camel", fabricationYear);
    }

    @Override
    public String toString() {
        return "camel " + getFabricationYear();
    }

    @Override
    public int getSellThreshold() {
        return 5;
    }
}
