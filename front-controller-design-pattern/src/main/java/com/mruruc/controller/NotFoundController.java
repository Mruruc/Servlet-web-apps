package com.mruruc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class NotFoundController {

    public void handle(HttpServletRequest request, HttpServletResponse response)  {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/not-found.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
