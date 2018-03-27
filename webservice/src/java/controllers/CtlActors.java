package controllers;

import domains.Actor;
import applications.AplActors;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonArrayBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Actors", urlPatterns = "/actors")
public class CtlActors extends CtlBase {
    private AplActors apl;

    public CtlActors() {
        apl = new AplActors();
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws ServletException, IOException {
        
        //TODO Tratar OPERACAO que vem do front e redirecionar para o método correto.
        request.getMethod();
        
        List actors = apl.getAll();
        JsonObject actorsJson = Json.createObjectBuilder()
                .add("data", list2Json(actors))
                .build();
        out.print(actorsJson.toString());
    }
    
    private JsonArrayBuilder list2Json(List<Actor> list) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        list.forEach(actor -> {
            builder.add(Json.createObjectBuilder()
                    .add("_id", actor.getId())
                    .add("name", actor.getName())
                    .add("titlesActuated", actor.getTitles().size()));
        });
        return builder;
    }

}
