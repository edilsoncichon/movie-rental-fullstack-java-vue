package domains.customer;

import domains.AplBase;
import java.util.Calendar;
import java.util.List;
import javax.json.JsonObject;
import support.DateUtils;

public class AplCustomersDependents extends AplBase {
    private DaoCustomersPartner daoPartners;
    
    public AplCustomersDependents() {
        this.dao = new DaoCustomersDependents();
        this.daoPartners = new DaoCustomersPartner();
    }

    public List getAllByPartnerId(int id) {
        return getDao().getAllByPartnerId(id);
    }
    
    public void save(JsonObject data) throws Exception {
        String name = data.getString("name");
        String sex = data.getString("sex");
        int partnerId = data.getInt("partnerId");
        CustomerPartner partner = (CustomerPartner) daoPartners.get(partnerId);
        Calendar birthDate = DateUtils.String2Calendar(data.getString("birthDate"), "yyyy-MM-dd");
       
        if (name.equals(""))
            throw new Exception("[name] not filled.");
        CustomerDependent item = new CustomerDependent(name, birthDate.getTime(), sex, partner);
        super.save(item);
    }
    
    public void delete(int id) throws Exception {
        CustomerDependent item = (CustomerDependent) this.get(id);
        this.delete(item);
    }
    
    private DaoCustomersDependents getDao() {
        return ((DaoCustomersDependents) this.dao);
    }
}
