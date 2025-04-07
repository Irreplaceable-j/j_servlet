package com.grepp.servlet.study.a_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// /request/* : 요청(request) url 이 /request 로 시작하면 이 서블릿의 메서드로 호출
// *.com : .com으로 끝나는 모든 요청을 처리
@WebServlet("/request/*")
public class A_Base extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String url = req.getRequestURI();
        String[] urlArr = url.split("/");

        switch (urlArr[urlArr.length - 1]) {
            case "get":
                testGet(req, resp);
                break;
            case "post":
                testPost(req, resp);
                break;
            default:
                resp.setStatus(404);
        }
    }

    private void testPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        System.out.println(name);


        PrintWriter pw = resp.getWriter();
        pw.write("<h1>Hello Servlet</h1>");
        pw.write(name + "<h2>post 요청</h2>");
    }

    private static void testGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
        String name = req.getParameter("name");
        System.out.println(name);

        PrintWriter pw = resp.getWriter();
        pw.write("<h1>Hello Servlet</h1>");
        pw.write(name + "<h2>get 요청</h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String url = req.getRequestURI();
        String[] urlArr = url.split("/");

        switch (urlArr[urlArr.length - 1]) {
            case "post":
                testPost(req, resp);
                break;
            default:
                resp.setStatus(404);
        }
    }
}
