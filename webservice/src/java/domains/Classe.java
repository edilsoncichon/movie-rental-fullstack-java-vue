package domains;

import java.io.Serializable;
import javax.persistence.*;
import javax.json.JsonObjectBuilder;

@Entity
public class Classe extends Domain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(nullable = true)
    private double value;
    @Column(nullable = true)
    private double maximumRentalTime;

    public Classe() {}

    public Classe(int id, String name, double value, double maximumRentalTime) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.maximumRentalTime = maximumRentalTime;
    }
    
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

    @Override
    public JsonObjectBuilder toJsonObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
