package com.mruruc.controller;

import com.mruruc.model.Contact;
import com.mruruc.service.ContactService;
import com.mruruc.validation.ValidationUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit-contact")
public class EditContact extends HttpServlet {
    private ContactService contactService;

    @Override
    public void init() {
        contactService = new ContactService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contactId = req.getParameter("contactId");
        if(contactId != null){
            Long id = Long.parseLong(contactId);
            req.setAttribute("contact", contactService.getContactById(id));
            req.getRequestDispatcher("/WEB-INF/views/contact/add-contact.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("./get-contacts");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contactId = req.getParameter("contactId");
        String name = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String state = req.getParameter("country");

        try{
            // construct the contact object
            if(contactId != null){
                Long id = Long.parseLong(contactId);
                Contact contact = new Contact(name, lastName, email, phone, address, city, state);
                contact.setContactId(id);
                contactService.updateContact(contact);
                resp.sendRedirect("./get-contact?contactId="+id);
                return;
            }
            throw new NullPointerException("Contact ID is null");
        }catch (Exception exception){
            exception.printStackTrace();
            req.setAttribute("error", exception.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/contact/add-contact.jsp").forward(req, resp);
        }


    }
}
