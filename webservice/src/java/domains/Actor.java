package domains;

public class Actor {
    private int id;
    private String name;
    private int titlesActuated;

    public Actor(int id, String name, int titlesActuated) {
        this.id = id;
        this.name = name;
        this.titlesActuated = titlesActuated;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTitlesActuated() {
        return titlesActuated;
    }

    public void setTitlesActuated(int titlesActuated) {
        this.titlesActuated = titlesActuated;
    }
}
