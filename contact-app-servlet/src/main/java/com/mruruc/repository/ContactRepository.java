package com.mruruc.repository;

import com.mruruc.model.Contact;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {

    @Insert("INSERT INTO contacts (user_id, first_name, last_name, phone, email, address, city, country) " +
            "VALUES (#{userId}, #{firstName}, #{lastName}, #{phone}, #{email}, #{address}, #{city}, #{country})")
    void save(Contact contact);

    @Select("SELECT * FROM contacts WHERE contact_id = #{contactId}")
    @Results({
            @Result(property = "contactId", column = "contact_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "createdDate", column = "created_at")
    })
    Optional<Contact> findById(Long contactId);

    @Select("SELECT * FROM contacts WHERE user_id = #{userId}")
    @Results({
            @Result(property = "contactId", column = "contact_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "createdDate", column = "created_at")
    })
   List<Contact> findAllByUserId(Long userId);



    @Select("SELECT * FROM contacts WHERE email LIKE #{email}")
    @Results({
            @Result(property = "contactId", column = "contact_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "createdDate", column = "created_at")
    })
    Optional<Contact> findByEmail(String email);

    @Select("SELECT * FROM contacts WHERE phone = #{phone}")
    @Results({
            @Result(property = "contactId", column = "contact_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "createdDate", column = "created_at")
    })
    Optional<Contact> findByPhone(String phone);

    @Update("UPDATE contacts " +
            "SET first_name = #{firstName}, last_name = #{lastName}, phone = #{phone},  email = #{email}, address = #{address}, city = #{city}, country = #{country} " +
            " WHERE contact_id = #{contactId} ")
    void update(Contact contact);

    @Delete("DELETE FROM contacts WHERE contact_id = #{contactId}")
    void delete(Long contactId);
}
