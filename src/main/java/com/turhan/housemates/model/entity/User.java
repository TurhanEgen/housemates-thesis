package com.turhan.housemates.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User{

    @Id
    private ObjectId userId;

    private String name;

    private String surName;

    private String userName;

    private String password;

    private String email;

    private String phoneNumber;


}
