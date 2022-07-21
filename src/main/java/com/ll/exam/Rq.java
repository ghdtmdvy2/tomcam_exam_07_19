package com.ll.exam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
    int param;
    HttpServletRequest req;
    HttpServletResponse resp;
    public Rq(HttpServletRequest req, HttpServletResponse resp)  {
        this.req = req;
        this.resp = resp;
        // 들어오는 파라미터를 UTF-8로 해석
        try {
            this.req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        // 서블릿이 HTML 파일을 만들 때 UTF-8 로 쓰기
        this.resp.setCharacterEncoding("UTF-8");
        // HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다.
        this.resp.setContentType("text/html; charset=utf-8");

    }

    public int getIntParam(String param, int i) {
        if ( req.getParameter(param) == null ){
            return i;
        }
        try {
            this.param = Integer.parseInt(req.getParameter(param));
        }
        catch (Exception e){
            return i;
        }
        return this.param;
    }

    public void appendBody(String formatted) {
        try {
            resp.getWriter().append(formatted);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
