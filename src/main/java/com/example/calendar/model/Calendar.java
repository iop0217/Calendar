package com.example.calendar.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Calendar {
    private String id;
    private String title;
    private String author;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Calendar(String title, String author, String password) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }
}
