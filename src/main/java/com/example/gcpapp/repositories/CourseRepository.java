package com.example.gcpapp.repositories;

import com.example.gcpapp.models.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    List<Course> findAll(Pageable pageable);
}
