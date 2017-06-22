package com.womantalk.funquiz.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;


@Entity
@Table (name ="t_option")
public class Option
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOption;

    @Column
    private String text;

    @Column
    private String imageURL;

    @Column
    private String type;

    @Column
    private Integer value;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "idQuestion")
    private Question question;

    public Option() {
    }

    public Integer getIdOption() {
        return idOption;
    }

    public void setIdOption(Integer idOption) {
        this.idOption = idOption;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
