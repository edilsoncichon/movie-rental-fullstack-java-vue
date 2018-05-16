package domains.customer;

import java.util.Date;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "customer_dependent")
@PrimaryKeyJoinColumn(name = "customer_id")
public class CustomerDependent extends Customer {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private CustomerPartner partner;
    
    public CustomerDependent() {}
    
    public CustomerDependent(String name, Date birthDate, String sex, CustomerPartner partner) {
        super(name, birthDate, sex);
        this.partner = partner;
    }

    public CustomerPartner getPartner() {
        return partner;
    }

    public void setPartner(CustomerPartner partner) {
        this.partner = partner;
    }

    @Override
    public JsonObjectBuilder toJsonObject() {
        return Json.createObjectBuilder()
                .add("_id", getId())
                .add("name", getName()+"")
                .add("sex", getSex()+"")
                .add("birthDate", getBirthDate().toString()+"");
    }
    
}
