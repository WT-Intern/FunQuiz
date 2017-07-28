package com.womantalk.funquiz.quizrules;

import com.womantalk.funquiz.quiz.Quiz;

import javax.persistence.*;



@Entity
@Table (name = "t_quizRules")
public class QuizRules
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (columnDefinition = "serial")
    private Integer idRules;

    @Column
    private  Integer min;

    @Column
    private Integer max;

    @Column
    private String value;

    @Column
    private String description;

    @Column
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
