package com.swufe.javaee.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbyServlet extends HttpServlet {
    private Map<String, List<String>> ho;
    private Object Lists;
    @Override
    public void init(){
        ho = new HashMap<>();

        ho.put("Bob", Arrays.asList("dating","scuba","skiing"));
        ho.put("Tom",Arrays.asList("knitting","scuba"));
        ho.put("Fred",Arrays.asList("knitting","scuba","dating"));
        ho.put("Jim",Arrays.asList("knitting","skiing"));
        ho.put("James",Arrays.asList("skiing","scuba","dating"));
        ho.put("Fei",Arrays.asList("scuba","dating"));
        ho.put("Jone",Arrays.asList("skiing","scuba"));
        ho.put("Pradeep",Arrays.asList("knitting","dating"));
        ho.put("Philippe",Arrays.asList("knitting","scuba","dating"));

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String hobby = request.getParameter("hobby");
       List<String> names = new ArrayList<>();
       ho.forEach((k, v) -> {
           if (v.contains(hobby)) {
               names.add(k);
           }
       });
       request.setAttribute("names", names);
        request.setAttribute("hobby", hobby);
       // Two JSPs have different UI styles.
       //  request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
       request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
    }

}
