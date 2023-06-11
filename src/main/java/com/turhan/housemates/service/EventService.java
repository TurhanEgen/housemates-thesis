package com.turhan.housemates.service;

import com.turhan.housemates.model.entity.Event;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public interface EventService {

    public List<Event> findAllEvent();
    public Event create(Event event,String houseId);
    public Event updateEvent(Event event);

    public void deleteEvent(ObjectId eventId);

    List<Event> findEventBetween(Date startDate, Date endDate);
}
