package http.controllers;

import domains.director.AplDirectors;
import domains.Domain;
import java.util.List;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Directors", urlPatterns = "/directors")
public class DirectorsController extends Controller {
    
    private AplDirectors apl;

    public DirectorsController() {
        this.apl = new AplDirectors();
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
        getResponse().renderOk("Director registered with success!");
    }
    
    public void processPut() throws Exception {
        String id = getServletRequest().getParameter("id");
        JsonObject data = getRequest().getContent();
        apl.update(
                Integer.valueOf(id),
                data.getString("name")
        );
        getResponse().renderOk("Director edited with success!");
    }

    public void processDelete() throws Exception {
        int id = Integer.valueOf(getServletRequest().getParameter("id"));
        apl.delete(id);
        getResponse().renderOk("Director deleted with success!");
    }
}
