package com.ll.exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 들어오는 파라미터를 UTF-8로 해석
        req.setCharacterEncoding("UTF-8");
        // 서블릿이 HTML 파일을 만들 때 UTF-8 로 쓰기
        resp.setCharacterEncoding("UTF-8");

        // HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다.
        resp.setContentType("text/html; charset=utf-8");
        // getParameter는 요청에서 ?dan=4&limit=4 를 dan에 값을 받아오는 것이다.
        int dan = Integer.parseInt(req.getParameter("dan"));
        // getParameter는 요청에서 ?dan=4&limit=4 를 limit에 값을 받아오는 것이다.
        int limit = Integer.parseInt(req.getParameter("limit"));

        // 브라우저에게 내용을 전송을 한다.
        resp.getWriter().append("<h1>%d단<h1>".formatted(dan));
        for (int i = 1; i<=limit; i++){
            resp.getWriter().append("<div>%d * %d = %d<div>".formatted(dan, i,dan*i));
        }
    }
}
