package dao;

import java.util.List;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

public abstract class DaoBase {

    protected Session session;
    protected Class domain;
    private final int SAVE = 0;
    private final int UPDATE = 1;
    private final int DELETE = 3;
    
    public DaoBase() {}
    
    private void persist(Object obj, int scenario) throws SQLException {
        try {
            session = openSession();
            session.beginTransaction();
            switch (scenario) {
                case SAVE:
                    session.save(obj); break;
                case UPDATE:
                    session.update(obj); break;
                case DELETE:
                    session.delete(obj); break;
                default: break;
            }
            session.getTransaction().commit();
            session.close();
        } catch (ConstraintViolationException ce) {
            session.getTransaction().rollback();
            session.close();
            throw new SQLException("Algum campo único já pertence a outro cadastro!");
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            session.close();
            throw he;
        }
    }
    
    public void save(Object obj) throws SQLException, ClassNotFoundException {
        persist(obj, SAVE);    
    }
    
    public void change(Object obj) throws SQLException, ClassNotFoundException {
        persist(obj, UPDATE);
    }
    
    public void delete(Object obj) throws SQLException, ClassNotFoundException {
        persist(obj, DELETE);
    }
     
    public List getAll() {
        List list;
        session = openSession();
        session.beginTransaction();
        Criteria cons = session.createCriteria(this.domain);
        list = cons.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    public Object get(int id) {
        Criteria crit = openSession().createCriteria(this.domain);
        crit.add(Restrictions.eq("id", id));
        List list = crit.list();
        session.close();
        return list.get(0);
    }
    
    public List search(String filter) {
        //TODO Implementar a busca por um termo...
        return null;
    }

    public Session openSession() {
        if (session != null && session.isOpen())
            session.close();
        session = config.database.HibernateConfig.getSessionFactory().openSession();
        return session;
    }
}
