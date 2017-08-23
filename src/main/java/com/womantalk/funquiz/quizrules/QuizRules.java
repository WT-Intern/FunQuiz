package com.womantalk.funquiz.quizrules;

import com.fasterxml.jackson.annotation.JsonView;
import com.womantalk.funquiz.quiz.Quiz;
import com.womantalk.funquiz.tools.View;

import javax.persistence.*;



@Entity
@Table (name = "t_quizRules")
public class QuizRules
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (columnDefinition = "serial")
    @JsonView(View.Public.class)
    private Integer idRules;

    @Column
    @JsonView(View.Public.class)
    private  Integer min;

    @Column
    @JsonView(View.Public.class)
    private Integer max;

    @Column
    @JsonView(View.Public.class)
    private String value;

    @Column
    @JsonView(View.Public.class)
    private String description;

    @Column
    @JsonView(View.Public.class)
    private String imageURL;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "idQuiz")
    private Quiz quiz;

    public QuizRules() {
    }

    public Integer getIdRules() {
        return idRules;
    }

    public void setIdRules(Integer idRules) {
        this.idRules = idRules;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz)
    {
        this.quiz = quiz;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
