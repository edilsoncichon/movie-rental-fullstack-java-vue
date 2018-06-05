package http.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domains.authentication.AplAuthentication;

public class FilterIsAuthenticated implements Filter {
    protected AplAuthentication aplAuth;

    public FilterIsAuthenticated() {
        this.aplAuth = new AplAuthentication();
    }
 
    @Override
    public void doFilter(ServletRequest sReq, ServletResponse sRes, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sReq;
        HttpServletResponse res = (HttpServletResponse) sRes;
        
        System.out.println("IsAuthenticated: " + req.getMethod());
 
        String sessionToken = req.getHeader("session-token");
        
        if ( !aplAuth.validateSessionToken(sessionToken) ) {
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        
        //Session authorized! Pass the requesition forward...
        
        chain.doFilter(sReq, sRes);
    }
    
    @Override
    public void init(FilterConfig fConfig) throws ServletException {}
    
    @Override
    public void destroy() {}
}