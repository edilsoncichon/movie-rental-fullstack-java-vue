package domains.customer;

import domains.user.User;
import domains.address.Address;
import java.util.Collection;
import java.util.Date;

public abstract class Customer {
    private int id;
    private String name;
    private String cpf;
    private Date birthDate;
    private Address address;
    private String sex;
    private User user;
    private Collection locations;

    public Customer(String name, String cpf, Date birthDate, Address address, String sex, User user, Collection locations) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.address = address;
        this.sex = sex;
        this.user = user;
        this.locations = locations;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection getLocations() {
        return locations;
    }

    public void setLocations(Collection locations) {
        this.locations = locations;
    }
    
}
