package com.englishweb.backend.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@Entity
public class Video {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String videoname;
	private String videoURL;
	private String videoId;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LessonID")
    private Lesson lesson = new Lesson();
	
	public Video() {
	}

	public Video(String videoname, String videoURL, int lesson, String videoId) {
		this.videoname = videoname;
		this.videoURL = videoURL;
		this.lesson.setLessonId(lesson);	
		this.videoId = videoId;
	}

}
