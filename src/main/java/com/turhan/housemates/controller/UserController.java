package com.turhan.housemates.controller;

import com.turhan.housemates.model.entity.User;
import com.turhan.housemates.service.UserService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getUserList(){
        List<User> userList = userService.getAllUser();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<User> update(@RequestBody User userUpdated){
        userService.updateUser(userUpdated);
        return new ResponseEntity<>(userUpdated,HttpStatus.CREATED);
    }



}
