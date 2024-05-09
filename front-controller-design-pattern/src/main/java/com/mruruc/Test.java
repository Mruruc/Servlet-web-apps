package com.mruruc;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/test")
public class Test extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {


        String servletName = super.getServletName();
        System.out.println("Servlet Name:"+servletName);

        String contextPath = request.getContextPath();
        System.out.println("Context Path:"+contextPath);

        String requestURI = request.getRequestURI();
        System.out.println("Request URI:"+requestURI);

        String servletPath = request.getServletPath();
        System.out.println("Servlet Path:"+servletPath);

        String pathInfo = request.getPathInfo();
        System.out.println("Path Info:"+pathInfo);


        HttpServletMapping httpServletMapping = request.getHttpServletMapping();
        System.out.println(httpServletMapping.getPattern());
        System.out.println();
    }
}
