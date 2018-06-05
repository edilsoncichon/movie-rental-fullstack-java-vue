package http.controllers;

import domains.Domain;
import domains.title.AplTitles;
import java.util.List;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Titles", urlPatterns = "/admin/titles")
public class TitlesController extends Controller {
    private AplTitles apl;

    public TitlesController() {
        apl = new AplTitles();
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
        getResponse().renderOk("Title registered with success!");
    }
    
    public void processPut() throws Exception {
        String id = getServletRequest().getParameter("id");
        JsonObject data = getRequest().getContent();
        apl.update(Integer.valueOf(id), data);
        getResponse().renderOk("Title edited with success!");
    }

    public void processDelete() throws Exception {
        int id = Integer.valueOf(getServletRequest().getParameter("id"));
        apl.delete(id);
        getResponse().renderOk("Title deleted with success!");
    }
}
