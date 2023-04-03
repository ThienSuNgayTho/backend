package com.englishweb.backend.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicDTO {
    
    private int topicId;
    private String topicName;

    public TopicDTO(int topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
    }

}
