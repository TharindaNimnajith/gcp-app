package com.example.gcpapp.controllers;

import com.example.gcpapp.models.Topic;
import com.example.gcpapp.services.TopicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @PostMapping(
        value = "/topics",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void addTopic(@RequestBody Topic topic) {
        log.info("CREATE");
        topicService.saveTopic(topic);
    }

    @PutMapping("/topics")
    public void updateTopic(@RequestBody Topic topic) {
        log.info("UPDATE");
        topicService.saveTopic(topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        log.info("DELETE");
        topicService.deleteTopic(id);
    }

    @GetMapping(
        value = "/topics/{id}",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Topic getTopic(@PathVariable String id) {
        log.info("READ");
        return topicService.getTopic(id);
    }

    @GetMapping(
        value = "/topics",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<Topic> getTopics() {
        log.info("READ LIST");
        return topicService.getTopics();
    }
}
