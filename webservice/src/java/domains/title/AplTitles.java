package domains.title;

import domains.AplBase;
import domains.actor.Actor;
import domains.actor.DaoActors;
import domains.classe.Classe;
import domains.classe.DaoClasses;
import domains.director.Director;
import domains.director.DaoDirectors;
import java.util.ArrayList;
import java.util.Collection;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;

public class AplTitles extends AplBase {
    protected DaoActors daoActors;
    protected DaoClasses daoClasses;
    protected DaoDirectors daoDirectors;
    protected DaoTitlesCategories daoCategories;
    
    public AplTitles() {
        this.dao = new DaoTitles();
        this.daoActors = new DaoActors();
        this.daoClasses = new DaoClasses();
        this.daoDirectors = new DaoDirectors();
        this.daoCategories = new DaoTitlesCategories();
    }

    public void save(JsonObject data) throws Exception {
        String name = data.getString("name");
        int year = Integer.valueOf(data.getString("year"));
        String sinopse = data.getString("sinopse");
        int categoryId = data.getInt("category_id");
        int classeId = data.getInt("classe_id");
        int directorId = data.getInt("director_id");
        if (name.equals(""))
            throw new Exception("[name] not filled.");
        TitleCategory tCategory = (TitleCategory) daoCategories.get(categoryId);
        Classe classe = (Classe) daoClasses.get(classeId);
        Director director = (Director) daoDirectors.get(directorId);
        Collection<Actor> actors = new ArrayList<>();
        JsonArray actorsIds = data.getJsonArray("actors");
        actorsIds.forEach(idActor -> {
            int id = ((JsonNumber) idActor).intValue();
            actors.add((Actor) daoActors.get(id));
        });
        Title title = new Title(name, sinopse, year, tCategory, classe, director, actors);
        super.save(title);
    }
    
    public void delete(int id) throws Exception {
        Title title = (Title) this.get(id);
        this.delete(title);
    }
    
    public void update(int id, JsonObject data) throws Exception {
        String name = data.getString("name");
        int year = Integer.valueOf(data.getString("year"));
        String sinopse = data.getString("sinopse");
        int categoryId = data.getInt("category_id");
        int classeId = data.getInt("classe_id");
        int directorId = data.getInt("director_id");
        if (name.equals(""))
            throw new Exception("[name] not filled.");
        TitleCategory tCategory = (TitleCategory) daoCategories.get(categoryId);
        Classe classe = (Classe) daoClasses.get(classeId);
        Director director = (Director) daoDirectors.get(directorId);
        Collection<Actor> actors = new ArrayList<>();
        JsonArray actorsIds = data.getJsonArray("actors");
        actorsIds.forEach(idActor -> {
            int idInt = ((JsonNumber) idActor).intValue();
            actors.add((Actor) daoActors.get(idInt));
        });
        
        Title title = (Title) this.get(id);
        title.setName(name);
        title.setYear(year);
        title.setSinopse(sinopse);
        title.setCategory(tCategory);
        title.setClasse(classe);
        title.setDirector(director);
        title.setActors(actors);
        this.update(title);
    }
}
