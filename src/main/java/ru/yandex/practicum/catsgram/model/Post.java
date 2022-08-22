package ru.yandex.practicum.catsgram.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Post {

    private Integer id;
    private final User author;
    private final LocalDate creationDate;
    private String description;
    private String photoUrl;

    public Post(Integer id, User author, String description, String photoUrl, LocalDate creationDate) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
        this.creationDate = creationDate;
    }


}