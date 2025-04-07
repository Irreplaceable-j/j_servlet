package com.grepp.servlet.study.a_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie/*")
public class D_cookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String url = req.getRequestURI();
        String[] urlArr = url.split("/");

        switch (urlArr[urlArr.length - 1]) {
            case "page":
                page(req, resp);
                break;
            case "lang":
                cookie(req,resp);
            default:
                resp.setStatus(404);
        }
    }

    private void cookie(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String search = req.getParameter("search");

        Cookie[] cookies = req.getCookies();

        String lastSearch = "최근 검색어가 없습니다.";

        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("last-search")) {
                    lastSearch = cookie.getValue();
                }
            }
        }

        String desc = "";
        String filePath = "";

        switch (search) {
            case "java":
                desc = "OOP 프로그래밍 언어";
                filePath = "/assets/img/java.png";
                break;
            case "html":
                desc = "HyperText markup language";
                filePath = "/assets/img/html.png";
                break;
            case "css":
                desc = "Cascading style sheet";
                filePath = "/assets/img/css.png";
                break;
            case "js":
                desc = "웹페이지를 위한 스크립트 언어";
                filePath = "/assets/img/js.webp";
                break;
            default:
                desc = "아름다운 강입니다.";
                filePath = "/assets/img/river1.PNG";
        }

        resp.setHeader("set-cookie", "last-search=" + search);
        req.setAttribute("lastSearch", lastSearch);
        req.setAttribute("search", search);
        req.setAttribute("desc", desc);
        req.setAttribute("filePath", filePath);
        req.getRequestDispatcher("/WEB-INF/view/study/c_cookie_result.jsp")
            .forward(req,resp);

    }

    private void page(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/study/c_cookie.jsp")
            .forward(req,resp);
    }
}
