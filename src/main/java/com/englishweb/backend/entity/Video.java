package com.englishweb.backend.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVideoname() {
		return videoname;
	}

	public void setVideoName(String videoname) {
		this.videoname = videoname;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoUR(String videoURL) {
		this.videoURL = videoURL;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}	

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	
}
