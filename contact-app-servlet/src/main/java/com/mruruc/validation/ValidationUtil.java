package com.mruruc.validation;

import com.mruruc.exception.ValidationException;
import com.mruruc.model.Contact;

public class ValidationUtil {

    public ValidationUtil() {}

    public boolean nullAndEmptyCheck(String... values) {
        for (String value : values) {
            if (value == null || value.isEmpty()) {
                throw new ValidationException("Value is null or empty!");
            }
        }
        return true;
    }

    public boolean validateContact(Contact contact) {
        return this.nullAndEmptyCheck(contact.getFirstName(), contact.getLastName(),
                    contact.getPhone(), contact.getEmail(), contact.getAddress(), contact.getCity(), contact.getCountry());
    }

    public void passwordMatchCheck(String password, String confirmPassword) {
        password= password.trim();
        confirmPassword= confirmPassword.trim();

        if (!password.equals(confirmPassword)) {
            throw new ValidationException("Passwords do not match!");
        }
    }

    public String extractUserNameFromEmail(String email) {
        return email.trim().split("@")[0];
    }
}
