package com.grepp.servlet.study.a_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/forward")
public class B_forward_jsp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        System.out.println("\n/jsp/forward");
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("subject"));

        // req.setAttribute 로 저장한 값을 가져옴
        System.out.println(req.getAttribute("score"));
        req.getRequestDispatcher("/WEB-INF/view/study/a_forward.jsp")
            .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        doGet(req,resp);
    }
}
