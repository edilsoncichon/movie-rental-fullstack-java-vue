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

/* @ WebFilter(asyncSupported = true, urlPatterns = { "/*" }) */
public class FilterCORS implements Filter {
 
    @Override
    public void doFilter(ServletRequest sReq, ServletResponse sRes, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sReq;
        HttpServletResponse res = (HttpServletResponse) sRes;
        System.out.println("FilterCORS HTTP Request: " + req.getMethod());
 
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, DELETE, POST");
        res.addHeader("Access-Control-Allow-Headers", "content-type, cache-control");
 
        // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
        if (req.getMethod().equals("OPTIONS")) {
            res.setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }
        // pass the request along the filter chain
        chain.doFilter(sReq, sRes);
    }
 
    @Override
    public void init(FilterConfig fConfig) throws ServletException {}
    
    @Override
    public void destroy() {}
}