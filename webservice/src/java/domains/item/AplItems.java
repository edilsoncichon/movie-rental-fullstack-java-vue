package domains.item;

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

public class AplItems extends AplBase {
    
    public AplItems() {
        this.dao = new DaoItems();
    }

    public void save(JsonObject data) throws Exception {
//        String name = data.getString("name");
//        int year = Integer.valueOf(data.getString("year"));
//        String sinopse = data.getString("sinopse");
//        int categoryId = data.getInt("category_id");
//        int classeId = data.getInt("classe_id");
//        int directorId = data.getInt("director_id");
//        if (name.equals(""))
//            throw new Exception("[name] not filled.");
//        TitleCategory tCategory = (TitleCategory) daoCategories.get(categoryId);
//        Classe classe = (Classe) daoClasses.get(classeId);
//        Director director = (Director) daoDirectors.get(directorId);
//        Collection<Actor> actors = new ArrayList<>();
//        JsonArray actorsIds = data.getJsonArray("actors");
//        actorsIds.forEach(idActor -> {
//            int id = ((JsonNumber) idActor).intValue();
//            actors.add((Actor) daoActors.get(id));
//        });
//        Title title = new Title(name, sinopse, year, tCategory, classe, director, actors);
//        super.save(title);
    }
    
    public void delete(int id) throws Exception {
        Item item = (Item) this.get(id);
        this.delete(item);
    }
    
    public void update(int id, JsonObject data) throws Exception {
//        String name = data.getString("name");
//        double value = data.getJsonNumber("value").doubleValue();
//        int maximumRentalTime = data.getInt("maximumRentalTime");
//        if (name.equals(""))
//            throw new Exception("[name] not filled.");
//        Title title = (Title) this.get(id);
//        title.setName(name);
//        title.setValue(value);
//        title.setMaximumRentalTime(maximumRentalTime);
//        this.update(title);
    }
}