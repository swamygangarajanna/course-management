package com.encoursa.app.coursemanagement.Services;

import com.encoursa.app.coursemanagement.models.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Business Service and internally is singleton
 */
@Service
public class TopicServices {

    private List<Topic> topics = new ArrayList(Arrays.asList(
            new Topic("spring" , "Spring framework" , "Spring framework"),
                new Topic("java" , "Core Java" , "Java enhanced"),
                new Topic("js" , "java scripts" , "Java script frameworks")

        ));

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().endsWith(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id,Topic topic) {
        Topic topicUpdatable = getTopic(id);
        if(topicUpdatable != null ){
            topicUpdatable.setName(topic.getName());
            topicUpdatable.setDescriptions(topic.getDescriptions());
        }else{
            addTopic(topic);
        }
    }

    public void deletTopic(String id) {

        Topic topicUpdatable = getTopic(id);
        if(topicUpdatable != null ){
            getTopics().remove(topicUpdatable);
        }
    }
}
