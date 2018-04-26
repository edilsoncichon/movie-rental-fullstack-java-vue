package domains.customer;

import domains.user.User;
import domains.address.Address;
import java.util.Date;
import java.util.Collection;
import javax.json.JsonObjectBuilder;

public class CustomerPartner extends Customer {
    private String cpf;
    private Address address;
    private Collection locations;
    private Collection dependents;
    private User user;

    public CustomerPartner() {}
    
    public CustomerPartner(String name, String cpf, Date birthDate, 
            Address address, String sex, Collection dependents, 
            Collection locations, User user) {
        super(name, birthDate, sex);
        this.dependents = dependents;
    }

    public Collection getDependents() {
        return dependents;
    }

    public void setDependents(Collection dependents) {
        this.dependents = dependents;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Collection getLocations() {
        return locations;
    }

    public void setLocations(Collection locations) {
        this.locations = locations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public JsonObjectBuilder toJsonObject() {
        throw new UnsupportedOperationException("[CustomerPartner] - Not supported yet.");
    }
    
}
