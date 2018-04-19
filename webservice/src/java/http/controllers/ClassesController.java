package http.controllers;

import domains.Domain;
import domains.classe.AplClasses;
import java.util.List;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Classes", urlPatterns = "/classes")
public class ClassesController extends Controller {
    private AplClasses apl;

    public ClassesController() {
        apl = new AplClasses();
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
        getResponse().renderOk("Actor registered with success!");
    }
    
    public void processPut() throws Exception {
        String id = getServletRequest().getParameter("id");
        JsonObject data = getRequest().getContent();
        apl.update(Integer.valueOf(id), data);
        getResponse().renderOk("Actor edited with success!");
    }

    public void processDelete() throws Exception {
        int id = Integer.valueOf(getServletRequest().getParameter("id"));
        apl.delete(id);
        getResponse().renderOk("Actor deleted with success!");
    }
}
