package com.grepp.servlet.study.b_filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain) throws IOException, ServletException {

        System.out.println("system : Encoding Filter");

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.setHeader("content-type", "text/html; charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
