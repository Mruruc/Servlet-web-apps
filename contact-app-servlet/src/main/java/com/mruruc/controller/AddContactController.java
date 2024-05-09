package com.mruruc.controller;

import com.mruruc.dto.UserDto;
import com.mruruc.model.Contact;
import com.mruruc.service.ContactService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/add-contact")
public class AddContactController extends HttpServlet {
    private ContactService contactService;
    @Override
    public void init() throws ServletException {
       contactService = new ContactService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/contact/add-contact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String country = request.getParameter("country");

        try {
            UserDto userDto = (UserDto) request.getSession().getAttribute("user");
            // construct the contact object
            Contact contact = new Contact(name, lastName, phone, email, address, city, country);
            // add the contact to the database

            Contact contact1 = contactService.addContact(userDto.getEmail(), contact);
            response.sendRedirect(request.getContextPath()+"/get-contact?contactId="+contact1.getContactId());

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage",e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/contact/add-contact.jsp").forward(request, response);
        }

    }
}
