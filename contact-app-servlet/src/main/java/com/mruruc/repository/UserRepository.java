package com.mruruc.repository;

import com.mruruc.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userId", column = "user_Id"),
            @Result(property = "userName", column = "username"),
            @Result(property = "createdDate", column = "created_at")
    })
    List<User> findAllUsers();


    @Select("SELECT * FROM users WHERE email = #{email}")
    @Results({
            @Result(property = "userId", column = "user_Id"),
            @Result(property = "userName", column = "username"),
            @Result(property = "createdDate", column = "created_at")
    })
    Optional<User> findUserByEmail(String email);

    @Insert("INSERT INTO users (username, email,password) VALUES (#{userName}, #{email},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void saveUser(User user);
}
