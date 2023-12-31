package com.turhan.housemates.repository;

import com.turhan.housemates.model.entity.Board;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends MongoRepository<Board, ObjectId> {
}
