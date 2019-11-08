package com.wjp.service.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wjp
 * @date 2019/10/29 11:15
 */
public class MyServletA extends HttpServlet {
    private static final long serialVersionUID = 5516398961835182763L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String message = "if you read this,it work";
        out.println("<HTML><BODY>");
        out.println("<H1>" + message + "<H1>");
        out.println("</BODY></HTML>");
        out.close();
    }
}
