package com.example.gcpapp.topic;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity(name = "topic")
@Table(name = "topic")
@JacksonXmlRootElement(localName = "Topic")
@Getter
public class Topic {

    @Id
    private String id;

    private String name;
    private String description;
}
