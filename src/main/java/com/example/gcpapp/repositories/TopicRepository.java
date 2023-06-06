package com.example.gcpapp.repositories;

import com.example.gcpapp.models.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
}
