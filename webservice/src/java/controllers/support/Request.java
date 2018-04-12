package controllers.support;

import javax.json.Json;
import java.io.IOException;
import java.io.StringReader;
import javax.json.JsonObject;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;

public class Request {
    private HttpServletRequest servletRequest;

    public Request(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }
    
    /**
     * Captura o conteúdo (body) da requisição em texto puro, e converte para 
     * um JsonObject manipulável.
     * 
     * @param req
     * @return
     * @throws IOException 
     */
    public JsonObject getContent() throws IOException {
        String data = servletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        JsonObject dataJson = Json.createReader(new StringReader(data)).readObject();
        return dataJson;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }
}
