package http.controllers;

import http.support.Request;
import http.support.Response;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller extends HttpServlet {
    private Request request;
    private Response response;
    
    private void boot(HttpServletRequest servletReq, HttpServletResponse servletRes) 
            throws IOException {
        this.request = new Request(servletReq);
        this.response = new Response(servletRes);
    }
    
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
        boot(req, res);
        try {
            processRequest("processGet");
        } catch (NoSuchMethodException e) {
            response.renderError("[GET] method not implemented for this resource!", 501);
        } catch (InvocationTargetException ex) {
            response.renderError(ex.getTargetException().getMessage() + " ", 500);
        } catch (Exception ex) {
            response.renderError("unknown error.", 500);
        }
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
        boot(req, res);
        try {
            processRequest("processPost");
        } catch (NoSuchMethodException e) {
            response.renderError("[POST] method not implemented for this resource!", 501);
        } catch (InvocationTargetException ex) {
            response.renderError(ex.getTargetException().getMessage() + " ", 500);
        } catch (Exception ex) {
            response.renderError("unknown error.", 500);
        }
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
        boot(req, res);
        try {
            processRequest("processPut");
        } catch (NoSuchMethodException e) {
            response.renderError("[PUT] method not implemented for this resource!", 501);
        } catch (InvocationTargetException ex) {
            response.renderError(ex.getTargetException().getMessage() + " ", 500);
        } catch (Exception ex) {
            response.renderError("unknown error.", 500);
        }
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
        boot(req, res);
        try {
            processRequest("processDelete");
        } catch (NoSuchMethodException e) {
            response.renderError("[DELETE] method not implemented for this resource!", 501);
        } catch (InvocationTargetException ex) {
            response.renderError(ex.getTargetException().getMessage() + " ", 500);
        } catch (Exception ex) {
            response.renderError("unknown error.", 500);
        }
    }
    
    private void processRequest (String name) throws Exception {
        this.getClass().getMethod(name).invoke(this);
    }
    
    public Request getRequest() {
        return request;
    }

    public Response getResponse() {
        return response;
    }
    
    public HttpServletRequest getServletRequest() {
        return request.getServletRequest();
    }
}
