package com.turhan.housemates.repository;

import com.turhan.housemates.model.entity.Adress;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends MongoRepository<Adress, ObjectId> {

}
