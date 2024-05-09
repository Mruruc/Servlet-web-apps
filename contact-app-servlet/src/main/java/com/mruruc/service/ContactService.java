package com.mruruc.service;

import com.mruruc.daoFactory.DaoFactory;
import com.mruruc.exception.ContactExistException;
import com.mruruc.exception.ContactNotFoundException;
import com.mruruc.exception.UserNotFoundException;
import com.mruruc.model.Contact;

import com.mruruc.model.User;
import com.mruruc.repository.ContactRepository;
import com.mruruc.validation.ValidationUtil;

import java.util.List;
import java.util.Optional;

public class ContactService {
    private ContactRepository contactRepository;
    private ValidationUtil validationUtil;
    private UserService userService;

    public ContactService() {
        contactRepository = DaoFactory.getContactDao();
        validationUtil = new ValidationUtil();
        userService = new UserService();
    }

    public Contact addContact(String userEmail,Contact contact) {
        // validate the contact
        validationUtil.nullAndEmptyCheck(contact.getFirstName(),contact.getLastName(),
                contact.getPhone(),contact.getEmail(),contact.getAddress(),contact.getCity(),contact.getCountry());
        // get the user by email and set the user id to the contact
        User userByEmail = userService.getUserByEmail(userEmail);

        contact.setUserId(userByEmail.getUserId());
        // check if contact with email or phone already exists
        this.ensureUniqueContact(contact.getEmail(),contact.getPhone());
        // save the contact
        contactRepository.save(contact);
        // return the saved contact
        return this.getContactByEmail(contact.getEmail()).orElseThrow(()->new ContactNotFoundException("Contact not found"));
    }

    public void updateContact(Contact contact) {
        Contact dbContact=contactRepository
                .findById(contact.getContactId())
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
        // validate the contact
       validationUtil.validateContact(contact);

        // update the contact
        contactRepository.update(contact);
    }

    private void ensureUniqueContact(String contactEmail,String contactPhone){
        this.getContactByEmail(contactEmail).ifPresent(contact -> {
            throw new ContactExistException("Contact with email already exists");
        });
        this.getContactByPhone(contactPhone).ifPresent(contact -> {
            throw new ContactExistException("Contact with phone already exists");
        });
    }

    public Optional<Contact> getContactByEmail(String email) {
        return contactRepository.findByEmail(email);

    }

    public Optional<Contact> getContactByPhone(String phone) {
        return contactRepository.findByPhone(phone);

    }

    public Contact getContactById(Long contactId) {
        return contactRepository
                .findById(contactId)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
    }

    public List<Contact> getAllContacts(String userEmail) {
        User userByEmail = userService.getUserByEmail(userEmail);
        return contactRepository.findAllByUserId(userByEmail.getUserId());
    }

    public void deleteContact(Long id) {
        contactRepository.delete(id);
    }
}
