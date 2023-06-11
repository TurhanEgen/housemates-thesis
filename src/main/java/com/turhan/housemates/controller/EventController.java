package com.turhan.housemates.controller;

import com.turhan.housemates.model.entity.Event;
import com.turhan.housemates.service.EventService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/event/{houseId}")
class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/getAllEvents")
    public List<Event> allEvents() {
        return eventService.findAllEvent();
    }

    @PostMapping("/createEvent")
    public Event createEvent(@RequestBody Event event, @PathVariable String houseId) {
        return eventService.create(event,houseId);
    }

    @PostMapping
    public Event updateEvent(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @DeleteMapping("{eventId}")
    public void removeEvent(@PathVariable ObjectId eventId) {
        eventService.deleteEvent(eventId);
    }

    @GetMapping("/getEventsBetween")
    public List<Event> getEventsInRange(@RequestParam(value = "start", required = true) Date start,
                                        @RequestParam(value = "end", required = true) Date end) {

        return eventService.findEventBetween(start, end);
    }

    /* @ResponseStatus(HttpStatus.BAD_REQUEST)
    class BadDateFormatException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public BadDateFormatException(String dateString) {
            super(dateString);
        }
    }*/
}