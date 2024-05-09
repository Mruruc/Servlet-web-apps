package com.mruruc.controller;

import com.mruruc.dto.UserDto;
import com.mruruc.model.Contact;
import com.mruruc.service.ContactService;
import com.mruruc.validation.ValidationUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/get-contact")
public class GetContact extends HttpServlet {
    private ContactService contactService;
    private ValidationUtil validationUtil;

    @Override
    public void init() {
        contactService = new ContactService();
        validationUtil = new ValidationUtil();
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contactId = req.getParameter("contactId");
        try {
            if(contactId != null ){
                Long.parseLong(contactId);
                Contact contactById = contactService.getContactById(Long.parseLong(contactId));
                req.setAttribute("contact", contactById);
                req.getRequestDispatcher("/WEB-INF/views/contact/get-contact.jsp").forward(req, resp);
            }
            else{
                UserDto userDto= (UserDto) req.getSession().getAttribute("user");
                List<Contact> allContacts = contactService.getAllContacts(userDto.getEmail());
                req.setAttribute("contacts", allContacts);

                req.getRequestDispatcher("/WEB-INF/views/contact/view-contacts.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", e.getMessage());
            if(contactId !=null){
                req.getRequestDispatcher("/WEB-INF/views/contact/get-contact.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("/WEB-INF/views/contact/view-contacts.jsp").forward(req, resp);
            }
        }
    }
}
