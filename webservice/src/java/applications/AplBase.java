package applications;

import dao.DaoBase;
import java.util.List;

public abstract class AplBase {
    protected DaoBase dao;
    
    public List getAll() {
        return dao.getAll();
    }
    
    public Object get(int id) throws Exception {
        try {
            return dao.get(id);
        } catch (IndexOutOfBoundsException ex) {
            throw new Exception("item ["+ id +"] not exists.");
        }
    }
    
    public void save(Object obj) throws Exception {
        dao.save(obj);
    }
    
    public void update(Object obj) throws Exception {
        dao.update(obj);
    }
    
    public void delete(Object obj) throws Exception {
        dao.delete(obj);
    }
}
