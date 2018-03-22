package servlets;

import domains.Actor;
import java.util.List;
import java.util.ArrayList;
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
public class Actors extends ServletBase {
    
    private List<Actor> actors;

    public Actors() {
        actors = new ArrayList();
        actors.add(new Actor(123, "Edilson Cichon", 5));
        actors.add(new Actor(123, "Fernanda Cichon", 10));
        actors.add(new Actor(12, "Ivone Cichon", 2));
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws ServletException, IOException {
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
                    .add("titlesActuated", actor.getTitlesActuated()));
        });
        return builder;
    }

}
