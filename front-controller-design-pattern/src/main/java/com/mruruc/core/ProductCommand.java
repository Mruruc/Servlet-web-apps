package com.mruruc.core;

import com.mruruc.controller.ProductController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ProductCommand implements Command{
    @Override
    public void getController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new ProductController().handle(request, response);
    }
}
