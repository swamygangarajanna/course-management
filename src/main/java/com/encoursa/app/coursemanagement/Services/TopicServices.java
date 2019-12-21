package com.encoursa.app.coursemanagement.Services;

import com.encoursa.app.coursemanagement.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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


    @Value("${course.topic.data.url}")
    private String topicBaseDataUrl;


    @Autowired
    RestTemplate restTemplate;

    public List<Topic> getTopics() {
        String url = topicBaseDataUrl + "topics";
        System.out.println("URL=" + url );
        ResponseEntity<List> listResponseEntity = restTemplate.getForEntity(url, List.class);
        return listResponseEntity.getBody();
    }

    public Topic getTopic(String id){
        ResponseEntity<Topic> topicResponseEntity = restTemplate.getForEntity(topicBaseDataUrl + "topic/" + id, Topic.class);
        return topicResponseEntity.getBody();
    }

    public void addTopic(Topic topic) {

        ResponseEntity<ResponseEntity> responseEntityResponseEntity = restTemplate.postForEntity(topicBaseDataUrl + "topics", topic, ResponseEntity.class);
        if(responseEntityResponseEntity.getStatusCode().is2xxSuccessful()){
            System.out.println("Successfully added " + topic.toString()) ;
        }else{
            System.out.println("Failed insertion") ;
        }
    }

    public void updateTopic(String id,Topic topic) {
        ResponseEntity<ResponseEntity> responseEntityResponseEntity = restTemplate.postForEntity(topicBaseDataUrl + "topics", topic, ResponseEntity.class);
        if(responseEntityResponseEntity.getStatusCode().is2xxSuccessful()){
            System.out.println("Successfully updated " + topic.toString()) ;
        }else{
            System.out.println("Failed to update") ;
        }
    }

    public void deletTopic(String id) {
        restTemplate.delete(topicBaseDataUrl + "topic/" + id);
    }

    public String getTopicBaseDataUrl() {
        return topicBaseDataUrl;
    }

    public void setTopicBaseDataUrl(String topicBaseDataUrl) {
        this.topicBaseDataUrl = topicBaseDataUrl;
    }
}
