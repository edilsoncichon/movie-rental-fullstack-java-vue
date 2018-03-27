package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Classes", urlPatterns = "/classes")
public class CtlClasses extends CtlBase {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, PrintWriter out) 
            throws ServletException, IOException {
        out.print("//implementar");
    }

}
