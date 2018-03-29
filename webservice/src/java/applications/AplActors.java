package applications;

import dao.DaoActors;
import domains.Actor;

public class AplActors extends AplBase {

    public AplActors() {
        this.dao = new DaoActors();
    }

    public void save(String name) throws Exception {
        Actor actor = new Actor(name);
        super.save(actor);
    }
    
}
