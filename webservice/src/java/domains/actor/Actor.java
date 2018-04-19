package domains.actor;

import domains.Domain;
import javax.json.Json;
import javax.persistence.*;
import java.io.Serializable;
import javax.json.JsonObjectBuilder;

@Entity
public class Actor extends Domain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Actor() {}

    public Actor(int id, String name) {
        this.id = id;
        this.name = name;
    }    
    
    public Actor(String name) {
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
        return Json.createObjectBuilder()
                .add("_id", getId())
                .add("name", getName());
    }
}
