package com.marcafut.infra.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.marcafut.infra.session.UserSession;

/**
 * Security filter application responsible for directing to the login screen
 * when the user is not authenticated.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
public class SecurityFilter implements Filter {

    private static final String LOGIN_PAGE = "/login.xhtml";

    @Inject
    private Logger logger;

    @Inject
    private UserSession userSession;
    
    @Override
    public void destroy() {
        logger.debug(SecurityFilter.class + " destroyed.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (this.isPublic(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        if (userSession == null || !userSession.isUserLogged()) {
            doRedirect(request, response, LOGIN_PAGE);
            return;
        }

        filterChain.doFilter(request, response);
        return;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    private void doRedirect(final HttpServletRequest req, final HttpServletResponse res, String url) throws IOException, ServletException {
        // JSF ajax request. Return a XML for JavaScript from JSF execute the
        // redirect in client side.
        if ("partial/ajax".equals(req.getHeader("Faces-Request"))) {
            res.setContentType("text/xml");
            res.getWriter().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").printf("<partial-response><redirect url=\"%s\"></redirect></partial-response>", url);
        } else {
            req.getRequestDispatcher(url).forward(req, res);
        }
    }

    private boolean isPublic(final HttpServletRequest request) {
        boolean acessoPublico = false;
        String requestURI = request.getRequestURI();

        if (requestURI.contains("/public/")) {
            acessoPublico = true;
        }

        return acessoPublico;
    }

}
