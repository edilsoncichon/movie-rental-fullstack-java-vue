package controllers;

import domains.Domain;
import applications.AplTitlesCategories;
import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet(name = "TitlesCategories", urlPatterns = "/titles_categories")
public class TitlesCategoriesController extends Controller {
    private AplTitlesCategories apl;

    public TitlesCategoriesController() {
        apl = new AplTitlesCategories();
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
}
