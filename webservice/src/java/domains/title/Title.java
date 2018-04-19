package domains.title;

import domains.Domain;
import domains.actor.Actor;
import domains.classe.Classe;
import domains.director.Director;
import javax.json.Json;
import java.io.Serializable;
import java.util.Collection;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;

@Entity
public class Title extends Domain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    private String sinopse;
    
    @Column(nullable = true)
    private int year;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = true)
    @Cascade(CascadeType.SAVE_UPDATE)
    private TitleCategory category;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classe_id")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Classe classe;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Director director;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "actor_title",
            joinColumns = @JoinColumn(name = "actor_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "title_id"))
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Actor> actors;

    public Title() {}

    public Title(int id, String name, String sinopse, int year, TitleCategory category, Classe classe, Director director, Collection<Actor> actors) {
        this.id = id;
        this.name = name;
        this.sinopse = sinopse;
        this.year = year;
        this.category = category;
        this.classe = classe;
        this.director = director;
        this.actors = actors;
    }
    
    public Title(String name, String sinopse, int year, TitleCategory category, Classe classe, 
            Director director, Collection actors) {
        this.name = name;
        this.sinopse = sinopse;
        this.year = year;
        this.category = category;
        this.classe = classe;
        this.director = director;
        this.actors = actors;
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

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public TitleCategory getCategory() {
        return category;
    }

    public void setCategory(TitleCategory category) {
        this.category = category;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Collection<Actor> getActors() {
        return actors;
    }

    public void setActors(Collection actors) {
        this.actors = actors;
    }

    @Override
    public JsonObjectBuilder toJsonObject() {
        JsonArrayBuilder actorsBuilder = Json.createArrayBuilder();
        getActors().forEach(actor -> {
            actorsBuilder.add(actor.toJsonObject());
        });
        return Json.createObjectBuilder()
                .add("_id", getId())
                .add("name", getName())
                .add("sinopse", getSinopse())
                .add("year", getYear())
                .add("category", getCategory().toJsonObject())
                .add("director", getDirector().toJsonObject())
                .add("classe", getClasse().toJsonObject())
                .add("actors", actorsBuilder);
    }
    
}
