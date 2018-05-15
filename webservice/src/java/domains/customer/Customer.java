package domains.customer;

import domains.Domain;
import java.util.Date;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Customer extends Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    private String sex;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date birthDate;
    
    public Customer() {}
    
    public Customer(String name, Date birthDate, String sex) {
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public Customer(int id, String name, String sex, Date birthDate) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
}
