package com.englishweb.backend.service;

import java.util.List;

import com.englishweb.backend.entity.Course;
import com.englishweb.backend.entity.Topic;

public interface TopicService {
            
    Topic findTopicById(int topicId);

}
