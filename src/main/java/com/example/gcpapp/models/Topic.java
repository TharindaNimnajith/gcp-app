package com.example.gcpapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Topic {

    @Id
    private String id;
    private String name;
    private String description;
}
