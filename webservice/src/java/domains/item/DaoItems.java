package domains.item;

import domains.DaoBase;
import domains.location.Location;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class DaoItems extends DaoBase {

    public DaoItems() {
        this.domain = Item.class;
    }
   
    public List getLocationsByItemId(int id) {
        Criteria crit = openSession().createCriteria(Location.class);
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        crit.add(Restrictions.eq("item.id", id));
        List list = crit.list();
        session.close();
        return list;
    }
    
    /**
     * Verifica se o item está locado.
     * 
     * @param item
     * @return 
     */
    public boolean isLocated(Item item) {
        List<Location> locations = this.getLocationsByItemId(item.getId());
        for (Location location : locations) {
            if (location.getReturnDate() == null)
                return true;
        }
        return false;
    }
    
}
