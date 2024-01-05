package com.example.eventCalendar.service;

import com.example.eventCalendar.model.Event;
import com.example.eventCalendar.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        //List<Event> events = eventRepository.findAll();
//        return events.stream()
//                .sorted(Comparator.comparingInt(Event::getPriority))
//                .toList();
        return eventRepository.findAllByOrderByPriorityAsc();
    }

    public void addEvent(Event event){
        eventRepository.save(event);
    }

    public Optional<Event> getById(Long id){
        return eventRepository.findById(id);
    }

    public void editEvent(Event event){
        eventRepository.save(event);
    }

    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

}
