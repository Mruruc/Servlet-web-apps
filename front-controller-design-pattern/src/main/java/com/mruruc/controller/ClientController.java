package com.mruruc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

public class ClientController {
    public ClientController() {
    }

    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();

        if (method.equals("GET")) {
            getMapping(request, response);
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

    private void getMapping(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("clients", Arrays.asList("client1", "client2", "client3"));
        request.getRequestDispatcher("/WEB-INF/clients.jsp").forward(request, response);

    }
}
