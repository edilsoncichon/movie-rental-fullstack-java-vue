package domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Actor extends Domain implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
//    @OneToMany(mappedBy = "actor", fetch = FetchType.EAGER)
//    @OnDelete(action = OnDeleteAction.NO_ACTION)
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    private Collection<Title> titles;

    public Actor() {}

    public Actor(String name, Collection<Title> titles) {
        this.name = name;
//        this.titles = titles;
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

//    public Collection getTitles() {
//        return titles;
//    }
//
//    public void setTitles(Collection titles) {
//        this.titles = titles;
//    }

    @Override
    public JsonObjectBuilder toJSON() {
        return Json.createObjectBuilder()
                .add("_id", getId())
                .add("name", getName())
                .add("titlesActuated", 1);
    }
}
