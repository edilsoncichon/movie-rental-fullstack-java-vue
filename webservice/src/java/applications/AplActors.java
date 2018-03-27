package applications;

import dao.DaoActors;
import domains.Actor;

public class AplActors extends AplBase {

    public AplActors() {
        this.dao = new DaoActors();
        this.domain = Actor.class;
    }
    
}
