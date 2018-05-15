package domains.customer;

import domains.location.Location;
import java.util.Date;
import java.util.Collection;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "customer_partner")
@PrimaryKeyJoinColumn(name = "customer_id")
public class CustomerPartner extends Customer {
    
    private String cpf;
    
    private String address;
    
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Location> locations;
    
    //@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    //@OnDelete(action = OnDeleteAction.NO_ACTION)
    //@Cascade(CascadeType.SAVE_UPDATE)
    //private Collection dependents;
    
    //private User user;

    public CustomerPartner() {}
    
    public CustomerPartner(String name, String cpf, Date birthDate, String address, String sex) {
        super(name, birthDate, sex);
        this.cpf = cpf;
        this.address = address;
        //this.dependents = dependents;
    }

    public CustomerPartner(int id, String name, Date birthDate, String cpf, String address, String sex) {
        super(id, name, sex, birthDate);
        this.cpf = cpf;
        this.address = address;
    }
    
//    public Collection getDependents() {
//        return dependents;
//    }

//    public void setDependents(Collection dependents) {
//        this.dependents = dependents;
//    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection locations) {
        this.locations = locations;
    }

//    public User getUser() {
//        return user;
//    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public JsonObjectBuilder toJsonObject() {
        JsonArrayBuilder locationsBuilder = Json.createArrayBuilder();
        getLocations().forEach(location -> {
            locationsBuilder.add(location.toJsonObject());
        });
        return Json.createObjectBuilder()
                .add("_id", getId())
                .add("name", getName()+"")
                .add("sex", getSex()+"")
                .add("birthDate", getBirthDate().toString()+"")
                .add("cpf", getCpf()+"")
                .add("address", getAddress()+"")
                .add("locations", locationsBuilder);
    }
    
}
