package com.example.gcpapp.controllers;

import com.example.gcpapp.models.Course;
import com.example.gcpapp.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/courses")
    public void addCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
    }

    @PutMapping("/courses")
    public void updateCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @QueryMapping
    public List<Course> recentCourses(@Argument int page, @Argument int size) {
        return courseService.getRecentCourses(page, size);
    }
}
