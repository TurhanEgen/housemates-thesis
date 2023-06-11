package com.turhan.housemates.service.impl;

import com.turhan.housemates.model.entity.Adress;
import com.turhan.housemates.model.entity.House;
import com.turhan.housemates.model.entity.User;
import com.turhan.housemates.model.entity.dto.UserHouseTransferDTO;
import com.turhan.housemates.repository.AdressRepository;
import com.turhan.housemates.repository.HouseRepository;
import com.turhan.housemates.repository.UserRepository;
import com.turhan.housemates.service.HouseService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class HouseServiceImpl implements HouseService {

    public HouseRepository houseRepository;
    public UserRepository userRepository;
    public AdressRepository adressRepository;



    public List<House> getAllHouse(){
        try{
            return houseRepository.findAll();


        }catch(NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public House createHouse(House house) {
        House houseCreated= new House();
        houseCreated.setHouseName(house.getHouseName());
        houseCreated.setAdress(house.getAdress());
        houseCreated.setHousemates(new ArrayList<UserHouseTransferDTO>());
        houseCreated.setEvents(new ArrayList<>());
        houseCreated.setBoardList(new ArrayList<>());

        //Create adress in the adress document and map it into the House
        Adress adress = house.getAdress();
        adressRepository.save(adress);

        return houseRepository.save(houseCreated);
    }

    @Override
    public House getHouseById(String houseId) {
        return houseRepository.findHouseByHouseId(houseId);
    }

    @Override
    public House updateHouse(House houseRequest) {
        houseRepository.save(houseRequest);
        return houseRequest;
    }

    @Override
    public House addUserById(ObjectId userId, String houseId) {

        User user = userRepository.findUsersByUserId(userId);
        UserHouseTransferDTO userSavedToHouse = new UserHouseTransferDTO(user.getUserId(),user.getUserName());
        House house = houseRepository.findHouseByHouseId(houseId);

        List<UserHouseTransferDTO> userList =  house.getHousemates();
        userList.add(userSavedToHouse);
        house.setHousemates(userList);
        houseRepository.save(house);
        return house;
    }

}
