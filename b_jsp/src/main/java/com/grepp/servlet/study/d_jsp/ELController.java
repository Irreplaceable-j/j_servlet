package com.grepp.servlet.study.d_jsp;

import com.grepp.servlet.study.d_jsp.dto.StudentDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/el/*")
public class ELController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String url = req.getRequestURI();
        String[] urlArr = url.split("/");

        switch (urlArr[urlArr.length - 1]) {
            case "base":
                req.getRequestDispatcher("/WEB-INF/view/el_base.jsp").forward(req, resp);
                break;
            case "exam":
                req.getRequestDispatcher("/WEB-INF/view/exam.jsp").forward(req, resp);
                break;
            case "view":
                view(req, resp);
                break;
            default:
                resp.setStatus(404);
        }
    }

    private void view(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String name = request.getParameter("name");
        int kor = Integer.parseInt(request.getParameter("kor"));
        int math = Integer.parseInt(request.getParameter("math"));
        int eng = Integer.parseInt(request.getParameter("eng"));
        int develop = Integer.parseInt(request.getParameter("develop"));

        int sum = kor + math + eng + develop;
        int avg = sum/4;

        request.setAttribute("sum", sum);
        request.setAttribute("avg", avg);

        StudentDto student = new StudentDto(name, kor, math, eng, develop);
        request.setAttribute("student", student);

        Map<String, Object> commandMap = new HashMap<String, Object>();
        commandMap.put("name", "map 에 담긴 이름 : " + name);
        commandMap.put("kor", kor);
        commandMap.put("math", math);
        commandMap.put("eng", eng);
        commandMap.put("develop", develop);
        commandMap.put("sum", sum);
        commandMap.put("avg", avg);

        request.setAttribute("studentMap", commandMap);

        List<StudentDto> studentList = new ArrayList<>();
        studentList.add(student);

        request.setAttribute("studentList", studentList);

        HttpSession session = request.getSession();
        session.setAttribute("principal", name+"(logout)");

        request.getRequestDispatcher("/WEB-INF/view/el.jsp")
            .forward(request, response);

    }
}
