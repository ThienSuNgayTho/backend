package com.englishweb.backend.entity;

public class ImageDTO {
    private Long id;
    private String imageName;
	private String imageURL;

    public ImageDTO(long id, String imageName, String imageURL){
        this.id = id;
        this.imageName = imageName;
        this.imageURL = imageURL;
    }

    public Long getid() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
