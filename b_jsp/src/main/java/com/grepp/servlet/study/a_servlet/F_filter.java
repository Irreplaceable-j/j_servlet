package com.grepp.servlet.study.a_servlet;

import com.grepp.servlet.infra.exception.CommonException;
import com.grepp.servlet.study.b_filter.wrapper.PathWrapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filter/*")
public class F_filter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String url = req.getRequestURI();
        String[] urlArr = url.split("/");

        switch (urlArr[urlArr.length - 1]) {
            case "error":
                throw new CommonException("Exception test");
            case "path":
                path(req, resp);
                break;
            default:
                resp.setStatus(404);
        }
    }

    private void path(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        PathWrapper pathWrapper = (PathWrapper) req;
        RequestDispatcher dispatcher = req.getRequestDispatcher("study/e_filter");

        System.out.println(pathWrapper.getWrappedPath());
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
