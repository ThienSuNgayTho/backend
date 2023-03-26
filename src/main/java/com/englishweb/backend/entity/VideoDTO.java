package com.englishweb.backend.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoDTO {
    private Long id;
    private String videoname;
	private String videoURL;

    public VideoDTO(long id, String videoname, String videoURL){
        this.id = id;
        this.videoname = videoname;
        this.videoURL = videoURL;
    }
    
}
