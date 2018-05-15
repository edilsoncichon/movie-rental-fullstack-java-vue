package domains.classe;

import domains.AplBase;
import javax.json.JsonObject;

public class AplClasses extends AplBase {

    public AplClasses() {
        this.dao = new DaoClasses();
    }

    public void save(JsonObject data) throws Exception {
        String name = data.getString("name");
        double value = data.getJsonNumber("value").doubleValue();
        int maximumRentalTime = data.getInt("maximumRentalTime");
        if (name.equals(""))
            throw new Exception("[name] not filled.");
        Classe classe = new Classe(name, value, maximumRentalTime);
        super.save(classe);
    }
    
    public void delete(int id) throws Exception {
        Classe classe = (Classe) this.get(id);
        this.delete(classe);
    }
    
    public void update(int id, JsonObject data) throws Exception {
        String name = data.getString("name");
        double value = data.getJsonNumber("value").doubleValue();
        int maximumRentalTime = data.getInt("maximumRentalTime");
        if (name.equals(""))
            throw new Exception("[name] not filled.");
        Classe classe = (Classe) this.get(id);
        classe.setName(name);
        classe.setValue(value);
        classe.setMaximumRentalTime(maximumRentalTime);
        this.update(classe);
    }
}
