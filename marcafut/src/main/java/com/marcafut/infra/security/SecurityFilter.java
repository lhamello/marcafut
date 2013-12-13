package com.marcafut.infra.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FIltro de segurança da aplicação resposável por redirecionar para a tela de
 * login quando o usuário não estiver autenticado.
 * 
 * @author Luiz Mello
 * 
 */
public class SecurityFilter implements Filter {

    // private static final String INDEX_PAGE = "/index.xhtml";
    private static final String LOGIN_PAGE = "/login.xhtml";

    // @Inject
    // private Logger logger;

    @Override
    public void destroy() {
        System.out.println(">>>>>>>>>>>> DESTROY");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (this.isPublico(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Não logado
        // if (sessaoUsuarioController == null ||
        // sessaoUsuarioController.getUsuarioED() == null) {
        // doRedirect(request, response, LOGIN_PAGE);
        // return;
        // }

        // TODO
        if (true) {
            doRedirect(request, response, LOGIN_PAGE);
            return;
        }

        filterChain.doFilter(request, response);
        return;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    private void doRedirect(final HttpServletRequest req,
            final HttpServletResponse res, String url) throws IOException,
            ServletException {
        // JSF ajax request. Retorna um XML de resposta para o JavaScript do JSF
        // executar o redirect no lado client.
        if ("partial/ajax".equals(req.getHeader("Faces-Request"))) {
            res.setContentType("text/xml");
            res.getWriter()
                    .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                    .printf("<partial-response><redirect url=\"%s\"></redirect></partial-response>",
                            url);
        } else {
            // Normal request. Excecuta redirect como de costume.
            // res.sendRedirect(url);
            req.getRequestDispatcher(url).forward(req, res);
        }
    }

    private boolean isPublico(final HttpServletRequest request) {
        boolean acessoPublico = false;
        String requestURI = request.getRequestURI();

        if (requestURI.contains("/public/")) {
            acessoPublico = true;
        }

        return acessoPublico;
    }

}
