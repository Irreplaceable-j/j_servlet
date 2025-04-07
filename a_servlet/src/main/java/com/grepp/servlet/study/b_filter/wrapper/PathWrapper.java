package com.grepp.servlet.study.b_filter.wrapper;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class PathWrapper extends HttpServletRequestWrapper {

    private final HttpServletRequest request;
    private String forwardUrl;

    public PathWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path){
        this.forwardUrl = "/WEB-INF/view/" + path + ".jsp";
        return request.getRequestDispatcher(forwardUrl);
    }

    public String getWrappedPath(){
        return this.forwardUrl;
    }
}