package com.englishweb.backend.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TopicID")
    private int topicId;

    @Column(name = "TopicName")
    private String topicName;

    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
    private List<Course> courses;

    // constructors, getters, and setters
    
}
