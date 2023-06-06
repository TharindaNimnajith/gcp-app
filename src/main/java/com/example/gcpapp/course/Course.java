package com.example.gcpapp.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Course {

    @Id
    private String id;
    private String name;
    private String description;
}
