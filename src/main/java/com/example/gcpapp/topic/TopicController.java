package com.example.gcpapp.topic;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        topicService.saveTopic(topic);
    }

    @PutMapping(
        value = "/topics",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void updateTopic(@RequestBody Topic topic) {
        topicService.saveTopic(topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }

    @GetMapping(
        value = "/topics/{id}",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @GetMapping(
        value = "/topics",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<Topic> getTopics() {
        return topicService.getTopics();
    }
}
