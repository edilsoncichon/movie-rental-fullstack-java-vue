package domains.customer;

import domains.location.Location;
import java.util.Date;
import java.util.Collection;
import javax.json.Json;
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
    
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Location> locations;
    
    @OneToMany(mappedBy = "partner", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<CustomerDependent> dependents;
    
    @Column(unique = true)
    private String email;
    
    private String password;

    public CustomerPartner() {}
    
    public CustomerPartner(String name, String cpf, Date birthDate, String address, String sex, String email, String password) {
        super(name, birthDate, sex);
        this.cpf = cpf;
        this.address = address;
        this.email = email;
        this.password = password;
        //this.dependents = dependents;
    }

    public CustomerPartner(int id, String name, Date birthDate, String cpf, String address, String sex, String email, String password) {
        super(id, name, sex, birthDate);
        this.cpf = cpf;
        this.address = address;
        this.email = email;
        this.password = password;
    }
    
    public Collection getDependents() {
        return dependents;
    }

    public void setDependents(Collection dependents) {
        this.dependents = dependents;
    };

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public JsonObjectBuilder toJsonObject() {
        return Json.createObjectBuilder()
                .add("_id", getId())
                .add("name", getName()+"")
                .add("sex", getSex()+"")
                .add("birthDate", getBirthDate().toString()+"")
                .add("cpf", getCpf()+"")
                .add("address", getAddress()+"")
                .add("email", getEmail()+"")
                .add("password", getPassword()+"");
    }
    
}
