package com.mruruc.controller;

import com.mruruc.service.ContactService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete-contact")
public class DeleteContact extends HttpServlet {
    private ContactService contactService;

    @Override
    public void init() {
        contactService = new ContactService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String contactId = req.getParameter("contactId");
        if(contactId != null){
            Long id = Long.parseLong(contactId);
            contactService.deleteContact(id);
            resp.sendRedirect("./get-contact");
        }else {
            resp.sendRedirect("./get-contact");
        }
    }
}
