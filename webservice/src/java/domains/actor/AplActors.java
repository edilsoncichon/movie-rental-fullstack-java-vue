package domains.actor;

import domains.AplBase;

public class AplActors extends AplBase {

    public AplActors() {
        this.dao = new DaoActors();
    }

    public void save(String name) throws Exception {
        if (name.equals(""))
            throw new Exception("[name] not filled.");
        Actor actor = new Actor(name);
        super.save(actor);
    }
    
    public void delete(int id) throws Exception {
        Actor actor = (Actor) this.get(id);
        this.delete(actor);
    }
    
    public void update(int id, String name) throws Exception {
        Actor actor = (Actor) this.get(id);
        actor.setName(name);
        this.update(actor);
    }
}
