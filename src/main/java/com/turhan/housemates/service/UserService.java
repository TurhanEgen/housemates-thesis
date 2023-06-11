package com.turhan.housemates.service;

import com.turhan.housemates.model.entity.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    void saveUser(User user);

    void updateUser(User user);

    User findUserById(ObjectId userId);

}
