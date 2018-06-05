package http.controllers;

import domains.Domain;
import domains.location.AplLocations;
import java.util.List;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Locations", urlPatterns = "/admin/locations")
public class LocationsController extends Controller {
    private AplLocations apl;

    public LocationsController() {
        apl = new AplLocations();
    }

    public void processGet() throws Exception {
        String id = getServletRequest().getParameter("id");
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
        getResponse().renderOk("Location registered with success!");
    }
    
    public void processPut() throws Exception {
        String id = getRequest().get("id");
        String operation = getRequest().get("operation");
        JsonObject data = getRequest().getContent();
        switch (operation) {
            case "makeUpdate": { makeUpdate(id, data); break; }
            case "makeReturn": { makeReturn(id, data); break; }
            default: getResponse().renderError("[operation] parameter is required!", 400);
        }
    }
    
    public void makeUpdate (String id, JsonObject data) throws Exception {
        apl.update(Integer.valueOf(id), data);
        getResponse().renderOk("Location edited with success!");
    }
    
    public void makeReturn (String id, JsonObject data) throws Exception {
        apl.makeReturn(Integer.valueOf(id), data);
        getResponse().renderOk("Return performed with success!");
    }

    public void processDelete() throws Exception {
        int id = Integer.valueOf(getServletRequest().getParameter("id"));
        apl.delete(id);
        getResponse().renderOk("Location deleted with success!");
    }
}
