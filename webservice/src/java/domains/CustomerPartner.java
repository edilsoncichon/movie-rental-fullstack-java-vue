package domains;

import java.util.Date;
import java.util.Collection;

public class CustomerPartner extends Customer {
    private Collection dependents;
    
    public CustomerPartner(String name, String cpf, Date birthDate, 
            Address address, String sex, User user, Collection dependents, Collection locations) {
        super(name, cpf, birthDate, address, sex, user, locations);
        this.dependents = dependents;
    }

    public Collection getDependents() {
        return dependents;
    }

    public void setDependents(Collection dependents) {
        this.dependents = dependents;
    }
    
}
