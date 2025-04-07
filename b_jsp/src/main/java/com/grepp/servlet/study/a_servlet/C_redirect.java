package com.grepp.servlet.study.a_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect/*")
public class C_redirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        
        String url = req.getRequestURI();
        String[] urlArr = url.split("/");

        switch (urlArr[urlArr.length - 1]) {
            case "page":
                page(req, resp);
                break;
            case "signup":
                signup(req,resp);
            default:
                resp.setStatus(404);
        }
    }

    private void signup(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("\n/redirect/signup");
        System.out.println("email : " + req.getParameter("email"));
        System.out.println("password : " + req.getParameter("password"));
        System.out.println("phone : " + req.getParameter("phone"));

        resp.sendRedirect("/?attr=signup");
    }

    private void page(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/study/b_redirect.jsp")
            .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        doGet(req,resp);
    }
}
