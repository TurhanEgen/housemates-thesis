package com.turhan.housemates.service.impl;

import com.turhan.housemates.model.entity.Event;
import com.turhan.housemates.model.entity.House;
import com.turhan.housemates.repository.EventRepository;
import com.turhan.housemates.repository.HouseRepository;
import com.turhan.housemates.service.EventService;
import com.turhan.housemates.service.HouseService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final HouseRepository houseRepository;
    private final HouseService houseService;
    @Override
    public List<Event> findAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public Event create(Event event, String houseId) {
        eventRepository.save(event);
        House house = houseRepository.findHouseByHouseId(houseId);
        List<Event> eventList = house.getEvents();
        eventList.add(event);
        house.setEvents(eventList);
        houseService.updateHouse(house);
        return event;
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(ObjectId eventId) {
        eventRepository.deleteByEventId(eventId);
    }

    @Override
    public List<Event> findEventBetween(Date startDate, Date endDate) {
        return eventRepository.findByStartGreaterThanEqualAndEndLessThanEqual(startDate,endDate);
    }
}
