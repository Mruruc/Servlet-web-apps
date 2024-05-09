package com.mruruc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductController {

    public void handle(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getMethod();
        if (method.equals("GET")) {
            System.out.println("GET method");
        } else if (method.equals("POST")) {
            System.out.println("POST method");
        } else if (method.equals("PUT")) {
            System.out.println("PUT method");
        } else if (method.equals("DELETE")) {
            System.out.println("DELETE method");
        } else {
            System.out.println("Invalid method");
        }

    }
}
