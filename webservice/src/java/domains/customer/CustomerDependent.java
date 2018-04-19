package domains.customer;

import domains.user.User;
import domains.address.Address;
import java.util.Collection;
import java.util.Date;

public class CustomerDependent extends Customer {
    private CustomerPartner partner;
    
    public CustomerDependent(String name, String cpf, Date birthDate, 
            Address address, String sex, User user, CustomerPartner partner, Collection locations) {
        super(name, cpf, birthDate, address, sex, user, locations);
        this.partner = partner;
    }

    public CustomerPartner getPartner() {
        return partner;
    }

    public void setPartner(CustomerPartner partner) {
        this.partner = partner;
    }
    
}
