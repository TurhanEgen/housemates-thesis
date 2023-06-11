package com.turhan.housemates.repository;

import com.turhan.housemates.model.entity.House;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends MongoRepository<House, String> {

    House findHouseByHouseId(String houseId);
}
