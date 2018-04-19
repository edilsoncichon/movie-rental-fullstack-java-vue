package http.controllers;

import domains.Domain;
import domains.actor.AplActors;
import javax.servlet.annotation.WebServlet;
import javax.json.JsonObject;
import java.util.List;

@WebServlet(name = "Actors", urlPatterns = "/actors")
public class ActorsController extends Controller {

    private AplActors apl;

    public ActorsController() {
        apl = new AplActors();
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
        apl.save(data.getString("name"));
        getResponse().renderOk("Actor registered with success!");
    }
    
    public void processPut() throws Exception {
        String id = getServletRequest().getParameter("id");
        JsonObject data = getRequest().getContent();
        apl.update(
                Integer.valueOf(id),
                data.getString("name")
        );
        getResponse().renderOk("Actor edited with success!");
    }

    public void processDelete() throws Exception {
        int id = Integer.valueOf(getServletRequest().getParameter("id"));
        apl.delete(id);
        getResponse().renderOk("Actor deleted with success!");
    }
    
}
