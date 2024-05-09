package com.mruruc.service;

import com.mruruc.daoFactory.DaoFactory;
import com.mruruc.dto.UserDto;
import com.mruruc.exception.UserNotFoundException;
import com.mruruc.model.Contact;
import com.mruruc.model.User;
import com.mruruc.repository.UserRepository;
import com.mruruc.validation.ValidationUtil;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;

    public UserService() {
        this.validationUtil = new ValidationUtil();
        this.userRepository = DaoFactory.getUserDao();
    }

    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    public User addUser(UserDto userDto) {
        // Validation
        validationUtil.nullAndEmptyCheck(userDto.getEmail(), userDto.getPassword(), userDto.getConfirmPassword());
        validationUtil.passwordMatchCheck(userDto.getPassword(), userDto.getConfirmPassword());
        //construct user object
        User user = new User();
        user.setEmail(userDto.getEmail());
        //hash password
        user.setPassword(
                BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(12))
        );
        user.setUserName(
                validationUtil.extractUserNameFromEmail(userDto.getEmail())
        );
        //save user
        userRepository.saveUser(user);
        //return saved user
        return this.getUserByEmail(user.getEmail());
    }

    public User getUserByEmail(String email) {
        return userRepository
                .findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }


    public UserDto login(UserDto userDto) {

        // Validation
        validationUtil.nullAndEmptyCheck(userDto.getEmail(), userDto.getPassword());
        //get user by email
        User user = this.getUserByEmail(userDto.getEmail());
        //check password
        if (!BCrypt.checkpw(userDto.getPassword(), user.getPassword())) {
            throw new UserNotFoundException("Invalid password");
        }
        UserDto validatedUserDto = new UserDto();
        validatedUserDto.setEmail(user.getEmail());
        validatedUserDto.setUserName(user.getUserName());
        return validatedUserDto;

    }



}
