package controllers.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;

public class FilterCheckTokenAuth implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {}

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        // Verificar se existe o header "token-auth";
        
        // Se é um recurso protegido, verificar antes de permitir o acesso;
        // Se não, permitir;
        
        System.err.println("//TODO FilterCheckTokenAuth");
    }

    @Override
    public void destroy() {}
    
}
