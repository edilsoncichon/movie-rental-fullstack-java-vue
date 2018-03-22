package servlets;

import domains.Customer;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonArrayBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Customers", urlPatterns = {"/customers"})
public class Customers extends ServletBase {
    
    private List<Customer> customers;

    public Customers() {
        super();
        customers = new ArrayList<>();
        customers.add(new Customer("Edilson Cichon", "13953108743", "10101992", "Rua x", "M", "VIP", "1", "no"));
        customers.add(new Customer("Fernanda Cichon", "13953108743", "10101992", "Rua x", "f", "VIP", "1", "no"));
        customers.add(new Customer("Ivone Cichon", "13953108743", "10101992", "Rua x", "f", "VIP", "1", "no"));
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws ServletException, IOException {
        JsonObject actorsJson = Json.createObjectBuilder()
                .add("data", list2Json(customers))
                .build();
        out.print(actorsJson.toString());
    }

    private JsonArrayBuilder list2Json(List<Customer> list) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        list.forEach(customer -> {
            builder.add(Json.createObjectBuilder()
                    .add("_id", customer.getId())
                    .add("name", customer.getName())
                    .add("birthDate", customer.getDtNascimento()));
        });
        return builder;
    }

}
