package domains;

import javax.persistence.*;
import java.io.Serializable;
import javax.json.JsonObjectBuilder;

@Entity
@Table(name = "title_category")
public class TitleCategory extends Domain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;

    public TitleCategory() {}

    public TitleCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public TitleCategory(String name) {
        this.name = name;
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

    @Override
    public JsonObjectBuilder toJsonObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
