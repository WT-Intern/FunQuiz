package com.womantalk.funquiz.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;


@Entity
@Table (name = "t_quizRules")
public class QuizRules
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRules;

    @Column
    private  Integer min;

    @Column
    private Integer max;

    @Column
    private Integer value;

    @Column
    private String description;

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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
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

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
