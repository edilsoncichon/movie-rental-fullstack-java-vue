package applications;

import dao.DaoGeneric;
import java.util.List;

public abstract class AplBase {
    protected DaoGeneric dao;
    
    public List getAll() {
        return dao.getAll();
    }
    
    public Object get(int id) {
        return dao.get(id);
    }
    
    public void save(Object obj) throws Exception {
        dao.save(obj);
    }
    
    public void change(Object obj) throws Exception {
        dao.change(obj);
    }
    
    public void delete(Object obj) throws Exception {
        dao.delete(obj);
    }
}
