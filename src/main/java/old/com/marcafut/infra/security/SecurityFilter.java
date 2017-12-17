package old.com.marcafut.infra.security;

/**
 * Security filter application responsible for directing to the login screen
 * when the user is not authenticated.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
//public class SecurityFilter implements Filter {
//
//    private static final String LOGIN_PAGE = "/login.xhtml";
//    private static final String CHARACTER_ENCODING = "UTF-8";
//    
//    @Inject
//    private Logger logger;
//
//    @Inject
//    private UserSession userSession;
//
//    @Override
//    public void destroy() {
//        logger.debug(SecurityFilter.class + " destroyed.");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        final HttpServletRequest request = (HttpServletRequest) servletRequest;
//        final HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        servletRequest.setCharacterEncoding(CHARACTER_ENCODING);
//        servletResponse.setCharacterEncoding(CHARACTER_ENCODING);
//
//        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;
//        httpResp.setHeader("X-UA-Compatible", "IE=Edge");
//
//        if (!isUrlPermitida(request) && (userSession == null || !userSession.isUserLogged())) {
//            doRedirect(request, response, LOGIN_PAGE);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        logger.debug(SecurityFilter.class + " initialized.");
//    }
//
//    private void doRedirect(final HttpServletRequest req, final HttpServletResponse res, String url) throws IOException, ServletException {
//        // JSF ajax request. Return a XML for JavaScript from JSF execute the
//        // redirect in client side.
//        if ("partial/ajax".equals(req.getHeader("Faces-Request"))) {
//            res.setContentType("text/xml");
//            res.getWriter().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").printf("<partial-response><redirect url=\"%s\"></redirect></partial-response>", url);
//        } else {
//            req.getRequestDispatcher(url).forward(req, res);
//        }
//    }
//
//    private boolean isUrlPermitida(HttpServletRequest request) {
//        String path = request.getServletPath();
//        // verify if request path is the login page
//        boolean pathEqualsLoginPage = StringUtils.equals(path, LOGIN_PAGE);
//        // verify if request path start with /javax.faces.resource
//        boolean pathStartsWithJavaxFacesResource = StringUtils.startsWith(path, "/javax.faces.resource");
//        // verify if request path contains /public/
//        boolean pathPublic = StringUtils.contains(path, "/public/");
//        
//        return pathEqualsLoginPage || pathStartsWithJavaxFacesResource || pathPublic;
//    }
//
//}