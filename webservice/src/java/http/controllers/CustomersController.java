package http.controllers;

import domains.Domain;
import domains.customer.AplCustomersPartners;
import java.util.List;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Customers", urlPatterns = {"/admin/customers"})
public class CustomersController extends Controller {
    private AplCustomersPartners apl;

    public CustomersController() {
        apl = new AplCustomersPartners();
    }

    public void processGet() throws Exception {
        String id = getRequest().get("id");
        if (id == null) {
            List list = apl.getAll();
            getResponse().renderList(list);
        } else {
            Domain domain = (Domain) apl.get(Integer.valueOf(id));
            getResponse().renderItem(domain);
        }
    }

    public void processPost() throws Exception {
        JsonObject data = getRequest().getContent();
        apl.save(data);
        getResponse().renderOk("Customer registered with success!");
    }
    
    public void processPut() throws Exception {
        String id = getRequest().get("id");
        JsonObject data = getRequest().getContent();
        apl.update(Integer.valueOf(id), data);
        getResponse().renderOk("Customer edited with success!");
    }

    public void processDelete() throws Exception {
        int id = Integer.valueOf(getRequest().get("id"));
        apl.delete(id);
        getResponse().renderOk("Customer deleted with success!");
    }
}
