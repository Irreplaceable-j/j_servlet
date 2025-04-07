package com.grepp.servlet.study.a_servlet;

import com.grepp.servlet.app.auth.Principal;
import com.grepp.servlet.app.auth.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


@WebServlet("/session/*")
public class E_session extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String url = req.getRequestURI();
        String[] urlArr = url.split("/");

        switch (urlArr[urlArr.length - 1]) {
            case "page":
                page(req, resp);
                break;
            case "login":
                login(req, resp);
            default:
                resp.setStatus(404);
        }
    }

    private void page(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/study/d_session.jsp")
            .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String url = req.getRequestURI();
        String[] urlArr = url.split("/");

        switch (urlArr[urlArr.length - 1]) {
            case "login":
                login(req, resp);
                break;
            default:
                resp.setStatus(404);
        }    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 메모리에 session 객체 생성
        // Session 저장소에 SessionId 를 key 로 session 객체 저장
        // response 응답 set-cookie 헤더에 jsessionid=sessionid 지정
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        resp.setHeader("set-cookie", "JSESSIONID="
            + session.getId()
            + "; max-age=3600; path=/");

        session.setAttribute("principal",
            new Principal(email, List.of(Role.ROLE_USER), LocalDateTime.now()));
        resp.sendRedirect("/");

    }
}
