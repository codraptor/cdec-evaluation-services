package com.cdec.validator.security.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Component
public class CorsFilterConfig extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        if ("http://localhost:3000".equals(request.getHeader("origin"))) {
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        } else if ("https://youthful-brahmagupta-d06e8f.netlify.app".equals(request.getHeader("origin"))) {
            response.setHeader("Access-Control-Allow-Origin", "https://youthful-brahmagupta-d06e8f.netlify.app");
        }

        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD, CONNECT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "authorization, accept, access-control-allow-origin, content-type, xsrf-token");
        response.addHeader("Access-Control-Expose-Headers", "xsrf-token");

        if (Arrays.asList("OPTIONS", "CONNECT").contains(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }

    }
}