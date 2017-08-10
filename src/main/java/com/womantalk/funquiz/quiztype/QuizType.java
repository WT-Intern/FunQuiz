package com.womantalk.funquiz.quiztype;

import com.fasterxml.jackson.annotation.JsonView;
import com.womantalk.funquiz.quiz.Quiz;
import com.womantalk.funquiz.tools.View;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name ="t_quizType")
public class QuizType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (columnDefinition = "serial")

    private Integer idQuizType;

    @Column
    @JsonView(View.Public.class)
    private String text;

    @OneToMany (mappedBy = "quizType", orphanRemoval = true)
    private Set <Quiz> quizs;

    @Version
    @Column(name = "optVersion", columnDefinition = "integer DEFAULT 0 ")
    private Integer version;

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

    public Set<Quiz> getQuizs() {
        return quizs;
    }

    public void setQuizs(Set<Quiz> quizs)
    {
        this.quizs = quizs;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
