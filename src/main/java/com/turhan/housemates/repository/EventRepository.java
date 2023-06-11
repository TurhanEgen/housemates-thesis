package com.turhan.housemates.repository;

import com.turhan.housemates.model.entity.Event;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event,Long> {

   List<Event> findByStartGreaterThanEqualAndEndLessThanEqual(Date start, Date end);
    void deleteByEventId(ObjectId eventId);
    Event findEventsByEventId(ObjectId eventId);
}
