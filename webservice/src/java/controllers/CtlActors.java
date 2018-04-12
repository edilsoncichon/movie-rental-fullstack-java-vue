package controllers;

import domains.Domain;
import applications.AplActors;
import java.util.List;
import java.io.IOException;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Actors", urlPatterns = "/actors")
public class CtlActors extends Ctl {

    private AplActors apl;

    public CtlActors() {
        apl = new AplActors();
    }

    public void processGet() throws IOException {
        String id = getServletRequest().getParameter("id");
        if (id == null) {
            List list = apl.getAll();
            getResponse().renderList(list);
        } else {
            Domain domain = (Domain) apl.get(Integer.valueOf(id));
            getResponse().renderItem(domain);
        }
    }

    public void processPost() throws IOException {
        try {
            JsonObject data = getRequest().getContent();
            apl.save(data.getString("name"));
            getResponse().renderOk("Actor registered with success!");
        } catch (Exception ex) {
            getResponse().renderError(ex.getMessage(), 500);
        }
    }
    //TODO To implement
    public void processPut() throws IOException, Exception {
        String id = getServletRequest().getParameter("id");
        
        JsonObject data = getRequest().getContent();
        apl.change(data.getString("name"));
        getResponse().renderOk("Actor edited with success!");
    }

    public void processDelete() throws IOException, Exception {
        int id = Integer.valueOf(getServletRequest().getParameter("id"));
        apl.delete(id);
        getResponse().renderOk("Actor deleted with success!");
    }
    
}
