package corp.fazsoft.app.app1.controller.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/html")
public class HtmlRouterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String url = servletRequest.getParameter("url");
        servletRequest.getRequestDispatcher("/WEB-INF/html/" + url).forward(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
