package controllers;

import domains.Domain;
import applications.AplBase;
import applications.AplActors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Actors", urlPatterns = "/actors")
public class CtlActors extends CtlBase {

    private AplBase apl;

    public CtlActors() {
        apl = new AplActors();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String id = req.getParameter("id");
        if (id == null) {
            List list = apl.getAll();
            out.print(toJSONResponse(list));
        } else {
            Domain domain = (Domain) apl.get(Integer.valueOf(id));
            out.print(toJSONResponse(domain));
        }
    }
}
