package com.turhan.housemates.controller;

import com.turhan.housemates.model.entity.House;
import com.turhan.housemates.service.HouseService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/house")
@AllArgsConstructor
public class HouseController {


    private final HouseService houseService;

    @GetMapping
    public ResponseEntity<List<House>> getAllHouses(){
        return new ResponseEntity<>(houseService.getAllHouse(), HttpStatus.OK);
    }

    @GetMapping("/{houseId}")
    public ResponseEntity<House> getHouseById(@PathVariable String houseId){
        House house = houseService.getHouseById(houseId);
        return new ResponseEntity<>(house,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<House> createHouse(@RequestBody House house){

        return new ResponseEntity<>(houseService.createHouse(house),HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<House> updateHouse(@RequestBody House houseChanged){

        return new ResponseEntity<>(houseService.updateHouse(houseChanged),HttpStatus.CREATED);
    }

    @PostMapping("/{houseId}/{userId}")
    public ResponseEntity<House> addUserToHouse(@PathVariable(name = "houseId") String houseId,@PathVariable(name = "userId") ObjectId userId){

        return new ResponseEntity<>(houseService.addUserById(userId,houseId),HttpStatus.CREATED);
    }
}
