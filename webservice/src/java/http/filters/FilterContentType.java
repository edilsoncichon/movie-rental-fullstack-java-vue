package http.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
 
/* @ WebFilter(asyncSupported = true, urlPatterns = { "/*" }) */
public class FilterContentType implements Filter {
 
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        res.setContentType("application/json;charset=UTF-8");
        chain.doFilter(req, res);
    }
 
    @Override
    public void init(FilterConfig fConfig) throws ServletException {}
    
    @Override
    public void destroy() {}
    
}
