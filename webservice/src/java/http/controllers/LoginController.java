package http.controllers;

import java.io.IOException;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;
import domains.authentication.AplAuthentication;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginController extends Controller {
    protected AplAuthentication apl;

    public LoginController() {
        this.apl = new AplAuthentication();
    }
    
    public void processPost () throws Exception {
        JsonObject data = getRequest().getContent();
        validateCredentials(data);
    }
    
    /**
     * Validate the username and password, and generate 
     * 'SessionToken' for send in header of every request.
     * 
     * @param data
     * @throws IOException 
     */
    private void validateCredentials (JsonObject data) throws IOException {
        //1 - recebe as credenciais, com a senha criptograda...
        String username = data.getString("username");
        String password = data.getString("password");
        String token = null;
        
        try {
            token = apl.validateCredentials(username, password);
        } catch (Exception e) {
            getResponse().renderError("Credentials invalids.", 403);
            return;
        }
        getResponse().renderOk(token);
    }
}
