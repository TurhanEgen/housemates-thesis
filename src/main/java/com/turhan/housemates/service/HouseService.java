package com.turhan.housemates.service;

import com.turhan.housemates.model.entity.Board;
import com.turhan.housemates.model.entity.House;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;



public interface HouseService {

    public List<House> getAllHouse();

    public House createHouse(House house);

    House addUserById(ObjectId userId,String houseId);

    House updateHouse(House houseChanged);

    House getHouseById(String houseId);
}
