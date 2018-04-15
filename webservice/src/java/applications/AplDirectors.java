package applications;

import domains.Director;
import dao.DaoDirectors;

public class AplDirectors extends AplBase {

    public AplDirectors() {
        this.dao = new DaoDirectors();
    }

    public void save(String name) throws Exception {
        if (name.equals(""))
            throw new Exception("[name] not filled.");
        Director domain = new Director(name);
        super.save(domain);
    }
    
    public void delete(int id) throws Exception {
        Director domain = (Director) this.get(id);
        this.delete(domain);
    }
    
    public void update(int id, String name) throws Exception {
        Director director = (Director) this.get(id);
        director.setName(name);
        this.update(director);
    }
}
