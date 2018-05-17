package domains.customer;

import domains.AplBase;
import java.util.Calendar;
import javax.json.JsonObject;
import support.DateUtils;

public class AplCustomersPartners extends AplBase {
    
    public AplCustomersPartners() {
        this.dao = new DaoCustomersPartner();
    }

    public void save(JsonObject data) throws Exception {
        String name = data.getString("name");
        String sex = data.getString("sex");
        String cpf = data.getString("cpf");
        Calendar birthDate = DateUtils.String2Calendar(data.getString("birthDate"), "yyyy-MM-dd");
        String address = data.getJsonObject("address").toString();
       
        if (name.equals(""))
            throw new Exception("[name] not filled.");
        CustomerPartner item = new CustomerPartner(name, cpf, birthDate.getTime(), address, sex);
        super.save(item);
    }
    
    public void delete(int id) throws Exception {
        CustomerPartner item = (CustomerPartner) this.get(id);
        this.delete(item);
    }
    
    public void update(int id, JsonObject data) throws Exception {
        String name = data.getString("name");
        String sex = data.getString("sex");
        String cpf = data.getString("cpf");
        Calendar birthDate = DateUtils.String2Calendar(data.getString("birthDate"), "yyyy-MM-dd");
        String address = data.getJsonObject("address").toString();
       
        if (name.equals(""))
            throw new Exception("[name] not filled.");
        CustomerPartner item = (CustomerPartner) this.get(id);
        item.setName(name);
        item.setSex(sex);
        item.setCpf(cpf);
        item.setBirthDate(birthDate.getTime());
        item.setAddress(address);
        super.update(item);
    }
}
