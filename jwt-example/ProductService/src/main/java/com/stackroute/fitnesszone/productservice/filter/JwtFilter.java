package com.stackroute.fitnesszone.productservice.filter;

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
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String authHeader = request.getHeader("authorization");

        if(request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request,response);
        } else {
            if(authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new ServletException("Missing or invalid Auth Header");
            }

            String token = authHeader.substring(7);

            Claims claims = Jwts.parser().setSigningKey("mysecret").parseClaimsJws(token).getBody();
            request.setAttribute("claims",claims);
            chain.doFilter(request,response);
        }

    }
}
