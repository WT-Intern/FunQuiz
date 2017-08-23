package com.womantalk.funquiz.quiztype;

import com.fasterxml.jackson.annotation.JsonView;
import com.womantalk.funquiz.quiz.Quiz;
import com.womantalk.funquiz.tools.View;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table (name ="t_quizType")
public class QuizType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (columnDefinition = "serial")

    @JsonView(View.Public.class)
    private Integer idQuizType;

    @Column
    @JsonView(View.Public.class)
    private String text;

    @OneToMany (mappedBy = "quizType", orphanRemoval = true)
    private List<Quiz> quizs;


    public QuizType() {
    }

    public Integer getIdQuizType() {
        return idQuizType;
    }

    public void setIdQuizType(Integer idQuizType) {
        this.idQuizType = idQuizType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Quiz> getQuizs() {
        return quizs;
    }

    public void setQuizs(List<Quiz> quizs) {
        this.quizs = quizs;
    }
}
