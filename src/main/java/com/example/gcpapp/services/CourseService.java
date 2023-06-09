package com.example.gcpapp.services;

import com.example.gcpapp.models.Course;
import com.example.gcpapp.models.Topic;
import com.example.gcpapp.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TopicService topicService;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public List<Course> getRecentCourses(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return courseRepository.findAll(pageable);
    }

    @SchemaMapping
    public Topic topic(Course course) {
        return topicService.getTopic(course.getTopicId());
    }

    @MutationMapping
    public Course createCourse(@Argument String id, @Argument String name, @Argument String description, @Argument String topicId) {
        return courseRepository.save(Course.builder()
            .id(id)
            .name(name)
            .description(description)
            .topicId(topicId)
            .build());
    }
}
