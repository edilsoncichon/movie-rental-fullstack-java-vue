package controllers.support;

import domains.Domain;
import java.io.IOException;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonArrayBuilder;
import javax.servlet.http.HttpServletResponse;

public class Response {
    private HttpServletResponse response;

    public Response(HttpServletResponse servletResponse) {
        this.response = servletResponse;
    }
    
    public void renderOk(String message) throws IOException {
        printMessage(message);
        setStatus(200);
    }
    
    public void renderError(String message, int statusCode) throws IOException {
        printMessage(message);
        setStatus(statusCode);
    }
    
    public void renderNotFound(String message) throws IOException {
        printMessage(message);
        setStatus(404);
    }
    
    /**
     * /TODO Refatorar, para desacoplar da camada de domínio (levar lógica para o controller).
     */
    public void renderItem(Domain domain) throws IOException {
        print(createItem(domain));
    }
    
    public void renderList(List list) throws IOException {
        print(createList(list));
    }
     
    public String createMessage(String message) {
        JsonObject listJson = Json.createObjectBuilder()
                    .add("message", message).build();
        return listJson.toString();
    }
    
    public String createList(List data) {
        JsonObject listJson = Json.createObjectBuilder()
                    .add("data", list2Json(data)).build();
        return listJson.toString();
    }
    
    /**
     * /TODO Refatorar, para desacoplar da camada de domínio (levar lógica para o controller).
     */
    public String createItem(Domain domain) {
        JsonObject objJSON = Json.createObjectBuilder()
                .add("data", domain.toJsonObject()).build();
        return objJSON.toString();
    }
    
    private void print(String value) throws IOException {
        response.getWriter().print(value);
    }
    
    private void printMessage (String message) throws IOException {
        print(createMessage(message));
    }
    
    private void setStatus (int code) {
        response.setStatus(code);
    }
    
    /**
     * //TODO Refatorar, para desacoplar da camada de domínio (levar lógica para o controller).
     * Converte um objeto List de Domains para um JsonArrayBuilder.
     * 
     * @param list
     * @return 
     */
    private JsonArrayBuilder list2Json(List<Domain> list) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        list.forEach(domain -> { builder.add(domain.toJsonObject()); });
        return builder;
    }
}
