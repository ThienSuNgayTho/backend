package com.englishweb.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.englishweb.backend.entity.Topic;
import com.englishweb.backend.repository.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService{

    @Autowired 
    private TopicRepository topicRepository;

    @Override
    public Topic findTopicById(int topicId){
        return topicRepository.findById(topicId).orElseThrow(() -> new IllegalArgumentException("Invalid topic Id:" + topicId));
    }
}