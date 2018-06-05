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
        String email = ""; //data.getString("email");
        String password = ""; // data.getString("password");
        Calendar birthDate = DateUtils.String2Calendar(data.getString("birthDate"), "yyyy-MM-dd");
        String address = data.getJsonObject("address").toString();
       
        if (name.equals(""))
            throw new Exception("[name] not filled.");
        CustomerPartner item = new CustomerPartner(name, cpf, birthDate.getTime(), address, sex, email, password);
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
        String email = ""; //data.getString("email");
        String password = ""; // data.getString("password");
        Calendar birthDate = DateUtils.String2Calendar(data.getString("birthDate"), "yyyy-MM-dd");
        String address = data.getJsonObject("address").toString();
       
        if (name.equals(""))
            throw new Exception("[name] not filled.");
        CustomerPartner customer = (CustomerPartner) this.get(id);
        customer.setName(name);
        customer.setSex(sex);
        customer.setCpf(cpf);
        customer.setBirthDate(birthDate.getTime());
        customer.setAddress(address);
        customer.setEmail(email);
        customer.setPassword(password);
        super.update(customer);
    }
    
}
