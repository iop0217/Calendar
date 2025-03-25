package com.example.calendar.controller;

import com.example.calendar.model.Calendar;
import com.example.calendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calender")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    // 일정 추가
    @PostMapping
    public Calendar createSchedule(@RequestBody Calendar newSchedule) {
        return calendarService.createSchedule(newSchedule);
    }

    // 전체 일정 조회
    @GetMapping
    public List<Calendar> getAllSchedules(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String date) {
        return calendarService.getAllSchedules(author, date);
    }

    // 일정 조회
    @GetMapping("/{id}")
    public Calendar getScheduleById(@PathVariable String id) {
        return calendarService.getScheduleById(id);
    }
}
