package org.osiam.security.helper;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: jtodea
 * Date: 25.06.13
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public class SSLRequestLoggingFilter implements Filter {

    protected Logger logger = Logger.getLogger(SSLRequestLoggingFilter.class.getName()); // NOSONAR - need it in tests

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getScheme().equals("http")) {
            logger.warn("SSL/TLS should be used");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}