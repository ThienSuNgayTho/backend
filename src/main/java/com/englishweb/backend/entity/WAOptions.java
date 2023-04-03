package com.englishweb.backend.entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class WAOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long option_id;

    @Column(name = "option_text")
    private String optionText;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private WAQuestions question;

    @Column(name = "is_correct")
    private boolean isCorrect;

    // getters and setters

    public Long getId() {
        return option_id;
    }

    public void setId(long option_id) {
        this.option_id = option_id;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
