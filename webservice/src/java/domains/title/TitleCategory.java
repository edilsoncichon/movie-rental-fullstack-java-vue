package domains.title;

import domains.Domain;
import javax.persistence.*;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

@Entity
@Table(name = "title_category")
public class TitleCategory extends Domain {
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
        return Json.createObjectBuilder()
                .add("_id", getId())
                .add("name", getName());
    }
    
}
