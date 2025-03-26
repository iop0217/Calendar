package com.example.calendar.controller;

import com.example.calendar.model.Calendar;
import com.example.calendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
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

    // 일정 수정
    @PutMapping("/{id}")
    public Calendar setSchedule(
            @PathVariable String id, @RequestParam String password, @RequestParam String title, @RequestParam String author) {
        return calendarService.setSchedule(id, password, title, author);
    }

    // 일정 삭제
    @DeleteMapping("/{id}")
    public Calendar deleteSchedule(@PathVariable String id, @RequestParam String password) {
        return calendarService.deleteSchedule(id, password);
    }
}
