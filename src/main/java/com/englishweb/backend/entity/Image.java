package com.englishweb.backend.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.FetchType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String imageName;
	private String imageURL;
	private String imageId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CourseID")
	private Course course = new Course();

	public Image() {
	}

	public Image(String imageName, String imageURL, String imageId, int course) {
		this.imageName = imageName;
		this.imageURL = imageURL;
		this.imageId = imageId;
		this.course.setCourseID(course);
	}

}
