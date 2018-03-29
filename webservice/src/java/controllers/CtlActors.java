package controllers;

import domains.Domain;
import applications.AplActors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import javax.json.JsonObject;

@WebServlet(name = "Actors", urlPatterns = "/actors")
public class CtlActors extends CtlBase {

    private AplActors apl;

    public CtlActors() {
        apl = new AplActors();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String id = req.getParameter("id");
        if (id == null) {
            List list = apl.getAll();
            out.print(toJSON(list));
        } else {
            Domain domain = (Domain) apl.get(Integer.valueOf(id));
            out.print(toJSON(domain));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            JsonObject data = getContentRequest(req);
            apl.save(data.getString("name"));
        } catch (Exception ex) {
            res.getWriter().print(toJSONError(ex.getMessage()));
            res.setStatus(500);
        }
    }
    
}
