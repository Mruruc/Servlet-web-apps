package com.mruruc.controller;

import com.mruruc.dto.UserDto;
import com.mruruc.exception.UserNotFoundException;
import com.mruruc.exception.ValidationException;
import com.mruruc.model.User;
import com.mruruc.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute("user") != null){
            req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(req, resp);
        }
        else{
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        try{

            UserDto newUserDto = new UserDto();
            newUserDto.setEmail(email);
            newUserDto.setPassword(password);
            newUserDto.setConfirmPassword(confirmPassword);

            User savedUser = userService.addUser(newUserDto);

            UserDto savedUserDto = new UserDto();
            savedUserDto.setEmail(savedUser.getEmail());
            savedUserDto.setUserName(savedUser.getUserName());

            req.getSession().setAttribute("user", savedUserDto);
            resp.sendRedirect(req.getContextPath() + "/dashboard");

        }catch (ValidationException | UserNotFoundException validationException){
            req.setAttribute("errorMessage", validationException.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
        }

    }
}
