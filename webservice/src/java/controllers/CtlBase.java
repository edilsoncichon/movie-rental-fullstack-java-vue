package controllers;

import domains.Domain;
import java.util.List;
import javax.json.Json;
import java.io.IOException;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletBase", urlPatterns = {"/ServletBase"})
public abstract class CtlBase extends HttpServlet {
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req servlet request
     * @param res servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.getWriter().print("Info: [GET] method not implemented for this resource!");
        res.setStatus(404);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req servlet request
     * @param res servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.getWriter().print("Info: [POST] method not implemented for this resource!");
        res.setStatus(404);
    }
    
    /**
     * Handles the HTTP <code>PUT</code> method.
     *
     * @param req servlet request
     * @param res servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.getWriter().print("Info: [PUT] method not implemented for this resource!");
        res.setStatus(404);
    }
    
    /**
     * Handles the HTTP <code>DELETE</code> method.
     *
     * @param req servlet request
     * @param res servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.getWriter().print("Info: [DELETE] method not implemented for this resource!");
        res.setStatus(404);
    }
    
    /**
     * Converte um objeto List de Domains para um JsonArrayBuilder.
     * 
     * @param list
     * @return 
     */
    protected JsonArrayBuilder list2Json(List<Domain> list) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        list.forEach(domain -> { builder.add(domain.toJSON()); });
        return builder;
    }
    
    protected String toJSONResponse(List data) {
        JsonObject listJson = Json.createObjectBuilder()
                    .add("data", list2Json(data)).build();
        return listJson.toString();
    }
    
    protected String toJSONResponse(Domain domain) {
        JsonObject objJSON = Json.createObjectBuilder()
                .add("data", domain.toJSON()).build();
        return objJSON.toString();
    }
}
