package com.womantalk.funquiz.option;

import com.fasterxml.jackson.annotation.JsonView;
import com.womantalk.funquiz.question.Question;
import com.womantalk.funquiz.tools.View;

import javax.persistence.*;


@Entity
@Table (name ="t_option")
public class Option
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (columnDefinition = "serial")
    @JsonView(View.Public.class)
    private Integer idOption;

    @Column
    @JsonView(View.Public.class)
    private String text;

    @Column
    @JsonView(View.Public.class)
    private String imageURL;

    @Column
    @JsonView(View.Public.class)
    private String type;

    @Column
    @JsonView(View.Public.class)
    private Integer value;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "id_question")

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
