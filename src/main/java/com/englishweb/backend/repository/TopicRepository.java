package com.englishweb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.englishweb.backend.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
    
}
