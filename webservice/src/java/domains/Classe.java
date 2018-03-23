package domains;

public class Classe {
    private int id;
    private String name;
    private double value;
    private double maximumRentalTime;

    public Classe(String name, double value, double maximumRentalTime) {
        this.name = name;
        this.value = value;
        this.maximumRentalTime = maximumRentalTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getMaximumRentalTime() {
        return maximumRentalTime;
    }

    public void setMaximumRentalTime(double maximumRentalTime) {
        this.maximumRentalTime = maximumRentalTime;
    }
    
}
