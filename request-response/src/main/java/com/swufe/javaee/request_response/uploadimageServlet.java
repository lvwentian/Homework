package com.swufe.javaee.request_response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns ="/uploadimage")
public class uploadimageServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("avator");
        part.write("C:\\Users\\admin\\Desktop\\javaeeswufemaster\\03_more_servlet\\a.JPG");
        response.sendRedirect("ok.html");

    }
}
