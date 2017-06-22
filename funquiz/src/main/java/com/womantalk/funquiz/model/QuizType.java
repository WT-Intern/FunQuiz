package com.womantalk.funquiz.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name ="t_quizType")
public class QuizType
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idQuizType;

    @Column
    private String typeName;

    @OneToMany (mappedBy = "quizType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
