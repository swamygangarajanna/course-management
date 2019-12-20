package com.encoursa.app.coursemanagement.controller;


import com.encoursa.app.coursemanagement.Services.TopicServices;
import com.encoursa.app.coursemanagement.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/CoursesTopic")
public class TopicController {

    @Autowired
    private TopicServices topicServices;

    @RequestMapping("/topics")
    public List<Topic> getTopics() {
        return topicServices.getTopics();
    }

    @RequestMapping("/topic/{identifier}")
    public Topic getTopic(@PathVariable("identifier") String id) {
        return topicServices.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/topics")
    public void addTopics(@RequestBody Topic topic) {
      topicServices.addTopic(topic);

    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topic/{id}")
    public void updateTopic(@PathVariable String id ,@RequestBody Topic topic){
        topicServices.updateTopic(id,topic);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topic/{id}")
    public void deletTopic(@PathVariable String id){
        topicServices.deletTopic(id);
    }
}
