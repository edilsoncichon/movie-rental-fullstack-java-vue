package domains.customer;

import java.util.Date;
import javax.json.JsonObjectBuilder;

public class CustomerDependent extends Customer {

    public CustomerDependent(String name, Date birthDate, String sex) {
        super(name, birthDate, sex);
    }

    @Override
    public JsonObjectBuilder toJsonObject() {
        throw new UnsupportedOperationException(
                "[CustomerDependent] - Not supported yet."
        );
    }
    
}
