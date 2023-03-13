package com.englishweb.backend.entity;

public class FlashCardDTO {
    private Long id;
    private String frontHTML;
    private String backHTML;

    public FlashCardDTO(Long id, String frontHTML, String backHTML) {
        this.id = id;
        this.frontHTML = frontHTML;
        this.backHTML = backHTML;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrontHTML() {
        return frontHTML;
    }

    public void setFrontHTML(String frontHTML) {
        this.frontHTML = frontHTML;
    }

    public String getBackHTML() {
        return backHTML;
    }

    public void setBackHTML(String backHTML) {
        this.backHTML = backHTML;
    }
}
