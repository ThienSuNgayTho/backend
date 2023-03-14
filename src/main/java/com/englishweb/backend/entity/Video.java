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

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LessonID")
	private String lessonID;
	
	public Video() {
	}

	public Video(String videoname, String videoURL, String lessonID) {
		this.videoname = videoname;
		this.videoURL = videoURL;
		this.lessonID = lessonID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String videoname() {
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

	public String getLessonID() {
		return lessonID;
	}

	public void setLessonID(String lessonID) {
		this.lessonID = lessonID;
	}
	
	
}
