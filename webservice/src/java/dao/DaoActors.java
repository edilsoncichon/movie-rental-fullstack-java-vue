package dao;

import domains.Actor;
import java.util.List;

public class DaoActors extends DaoGeneric {

    public List getAll() {
        List<Actor> list = super.getAll(Actor.class);
        //TESTE
        list.add(new Actor("Edilson Cichon", null));
        list.add(new Actor("Fernanda Cichon", null));
        list.add(new Actor("Ivone Cichon", null));
        return list;
    }
    
}
