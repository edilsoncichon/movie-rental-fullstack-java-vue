package domains.customer;

import domains.DaoBase;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class DaoCustomersDependents extends DaoBase {

    public DaoCustomersDependents() {
        this.domain = CustomerDependent.class;
    }
    
    public List getAllByPartnerId(int id) {
        List list;
        session = openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(this.domain);
        criteria.add(Restrictions.eq("partner.id", id));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
