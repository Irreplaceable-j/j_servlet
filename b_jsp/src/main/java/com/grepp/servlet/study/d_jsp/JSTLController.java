package com.grepp.servlet.study.d_jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jstl/page")
public class JSTLController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String xss = "<script>alert('xss attack!);</script>";
        req.setAttribute("xss", xss);
        req.getRequestDispatcher("/WEB-INF/view/jstl.jsp")
            .forward(req, resp);
    }
}
