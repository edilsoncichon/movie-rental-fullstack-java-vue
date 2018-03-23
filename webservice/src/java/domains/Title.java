package domains;

import java.util.Collection;

public class Title {
    private int id;
    private String name;
    private int year;
    private TitleCategory category;
    private Classe classe;
    private Director director;
    private Collection actors;
    private Collection items;

    public Title(String name, int year, TitleCategory category, Classe classe, Director director, Collection actors, Collection items) {
        this.name = name;
        this.year = year;
        this.category = category;
        this.classe = classe;
        this.director = director;
        this.actors = actors;
        this.items = items;
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

    public Collection getActors() {
        return actors;
    }

    public void setActors(Collection actors) {
        this.actors = actors;
    }

    public Collection getItems() {
        return items;
    }

    public void setItems(Collection items) {
        this.items = items;
    }
    
}
