package domains.authentication;

import domains.AplBase;
import domains.customer.CustomerPartner;
import domains.customer.DaoCustomersPartner;

public class AplAuthentication extends AplBase {
    
    public AplAuthentication() {
        this.dao = new DaoCustomersPartner();
    }
    
    /**
     * Valida as credenciais, retornando um token caso um Cliente seja encontrado
     * para as credenciais, senão dispara uma exceção.
     * 
     * @param username
     * @param password
     * @return 
     * @throws java.lang.Exception 
     */
    public String validateCredentials(String username, String password) throws Exception {
        CustomerPartner customer = (CustomerPartner) dao.getByColumn("email", username);
        
        if (customer != null && customer.getPassword().equals(password)) {
            return username + password; 
            //TODO lógica pra gerar um token criptografado...
            // TALVEZ UM JWT ????
        }
        throw new Exception("Username or Password invalid!");
    }
    
    /**
     * Verifica se um dado token é válido.
     * 
     * @param token
     * @return 
     */
    public boolean validateSessionToken(String token) {
        // TODO USAR A MESMA LÓGICA QUE GEROU O TOKEN!
        // Obter e verificar se o usuário existe no banco;
        // Verificar se a senha está certa;
        // Verificar se o token expirou;
        return token != null && token != "";
    }
}
