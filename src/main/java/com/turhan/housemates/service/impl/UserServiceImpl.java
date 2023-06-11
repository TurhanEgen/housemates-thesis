package com.turhan.housemates.service.impl;

import com.turhan.housemates.model.entity.User;
import com.turhan.housemates.repository.UserRepository;
import com.turhan.housemates.service.UserService;
import com.turhan.housemates.utility.Util;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;


    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        try{
            if(user.getUserId()==null){
                throw new RuntimeException("User cannot updated. user cannot found in the system");
            }

        }catch(NullPointerException e){
            Util.createGeneralExceptionInfo(e);
        }
        userRepository.save(user);
    }

    @Override
    public User findUserById(ObjectId userId) {
        try{
            User userFound = userRepository.findUsersByUserId(userId);
            if(userFound == null){
                throw new RuntimeException("User can not found with id " + userId);
            }
            return userFound;

        }catch (NullPointerException e){
            Util.createGeneralExceptionInfo(e);
        }

        return null;
    }
}
