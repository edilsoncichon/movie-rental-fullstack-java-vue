package domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Actor implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Collection titles;

    public Actor() {}

    public Actor(String name, Collection titles) {
        this.name = name;
        this.titles = titles;
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

    public Collection getTitles() {
        return titles;
    }

    public void setTitles(Collection titles) {
        this.titles = titles;
    }
}
