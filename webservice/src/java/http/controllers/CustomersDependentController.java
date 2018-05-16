package http.controllers;

import domains.Domain;
import domains.customer.AplCustomersDependents;
import java.util.List;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "CustomersDependents", urlPatterns = {"/customers-dependents"})
public class CustomersDependentController extends Controller {
    private AplCustomersDependents apl;

    public CustomersDependentController() {
        apl = new AplCustomersDependents();
    }

    public void processGet() throws Exception {
        String operation = getRequest().get("operation");
        operation =  operation == null ? "getAll" : operation;
        String id = getRequest().get("id");
        List list;
        
        switch (operation) {
            case "getAllByPartnerId": {
                list = apl.getAllByPartnerId(Integer.valueOf(id));
                getResponse().renderList(list);
                break;
            }
            case "getById": {
                Domain domain = (Domain) apl.get(Integer.valueOf(id));
                getResponse().renderItem(domain);
                break;
            }
            default: {
                list = apl.getAll();
                getResponse().renderList(list);
            }
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
