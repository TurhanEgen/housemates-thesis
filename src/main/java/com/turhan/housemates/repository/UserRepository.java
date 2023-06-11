package com.turhan.housemates.repository;

import com.turhan.housemates.model.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findUsersByUserId(ObjectId objectId);
}
