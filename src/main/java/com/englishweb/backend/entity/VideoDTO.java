package com.englishweb.backend.entity;

public class VideoDTO {
    private Long id;
    private String videoname;
	private String videoURL;

    public VideoDTO(long id, String videoname, String videoURL){
        this.id = id;
        this.videoname = videoname;
        this.videoURL = videoURL;
    }

    public Long getid() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoname;
    }

    public void setVideoName(String videoname) {
        this.videoname = videoname;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
