package app.players.recommendationservice.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        final String authHeader = request.getHeader("authorization");

        if(request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request,response);
        } else {
            if(authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new ServletException("Missing or invalid Auth Header");
            }

            final String token = authHeader.substring(7);

            Claims claims= Jwts.parser().setSigningKey("mysecret").parseClaimsJws(token).getBody();
            request.setAttribute("claims",claims);;
            chain.doFilter(request,response);
        }

    }
}
