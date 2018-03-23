package servlets;

import domains.CustomerPartner;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonArrayBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Customers", urlPatterns = {"/customers"})
public class Customers extends ServletBase {
    
    private List<CustomerPartner> partners;

    public Customers() {
        super();
        partners = new ArrayList<>();
        partners.add(new CustomerPartner("Edilson Cichon", "13953108743", new Date(1992, 10, 10), null, "M", null, null, null));
        partners.add(new CustomerPartner("Fernanda Cichon", "13953108743", new Date(1992, 10, 10), null, "F", null, null, null));
        partners.add(new CustomerPartner("Ivone Cichon", "13953108743", new Date(1992, 10, 10), null, "F", null, null, null));
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws ServletException, IOException {
        JsonObject actorsJson = Json.createObjectBuilder()
                .add("data", list2Json(partners))
                .build();
        out.print(actorsJson.toString());
    }

    private JsonArrayBuilder list2Json(List<CustomerPartner> list) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        list.forEach(customer -> {
            builder.add(Json.createObjectBuilder()
                    .add("_id", customer.getId())
                    .add("name", customer.getName())
                    .add("birthDate", customer.getBirthDate().toString()));
        });
        return builder;
    }

}
