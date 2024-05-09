package com.mruruc.core;

import com.mruruc.controller.NotFoundController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class NotFoundCommand implements Command {
    @Override
    public void getController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new NotFoundController().handle(request, response);
    }
}
