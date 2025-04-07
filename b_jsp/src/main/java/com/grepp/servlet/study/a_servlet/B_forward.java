package com.grepp.servlet.study.a_servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward/*")
public class B_forward extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String url = req.getRequestURI();
        String[] urlArr = url.split("/");

        switch (urlArr[urlArr.length - 1]) {
            case "servlet":
                forwardServlet(req, resp);
                break;
            default:
                resp.setStatus(404);
        }

    }

    private void forwardServlet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        System.out.println("\nforward/servlet");
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("subject"));

        // HttpServletRequest 객체에 score 를 저장
        req.setAttribute("score", 100);

        // forward : /jsp/forward 과 매칭된 Servlet 으로 forward 할 경로를 지정
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/forward");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
