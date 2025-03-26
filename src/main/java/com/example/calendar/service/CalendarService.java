package com.example.calendar.service;

import com.example.calendar.model.Calendar;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarService {
    private List<Calendar> schedules = new ArrayList<>();

    // 일정 추가
    public Calendar createSchedule(Calendar newSchedule) {
        schedules.add(newSchedule);
        return newSchedule;
    }

    // 전체 일정 조회
    public List<Calendar> getAllSchedules(String author, String date) {
        return schedules.stream()
                .filter(schedule -> (author == null || schedule.getAuthor().equals(author)) &&
                        (date == null || schedule.getUpdatedAt().toLocalDate().toString().equals(date)))
                .collect(Collectors.toList());
    }

    // 일정 조회
    public Calendar getScheduleById(String id) {
        for (Calendar schedule : schedules) {
            if (schedule.getId().equals(id)) {
                return schedule;
            }
        }
        return null;
    }

    // 일정 수정
    public Calendar setSchedule(String id, Calendar newSchedule) {
        Calendar schedule = getScheduleById(id);

        if (schedule == null || !schedule.getPassword().equals(newSchedule.getPassword())) {
            return null;
        }

        schedule.setTitle(newSchedule.getTitle());
        schedule.setAuthor(newSchedule.getAuthor());
        schedule.setUpdatedAt(LocalDateTime.now());

        return schedule;
    }

    // 일정 삭제
    public Calendar deleteSchedule(String id, String password) {
        Calendar schedule = getScheduleById(id);

        if (schedule == null || !schedule.getPassword().equals(password)) {
            return null;
        }

        schedules.remove(schedule);
        return schedule;
    }
}