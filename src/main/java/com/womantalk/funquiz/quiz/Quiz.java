package com.womantalk.funquiz.quiz;

import com.womantalk.funquiz.question.Question;
import com.womantalk.funquiz.quizrules.QuizRules;
import com.womantalk.funquiz.quiztype.QuizType;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table (name ="t_quiz")
public class Quiz
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (columnDefinition = "serial")
    private Integer idQuiz;

    @Column
    private String judulQuiz;

    @Column
    private String imageURL;

    @Column(name = "status")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "draft_date")
    public Date draft_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "published_date")
    public Date published_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified")
    public Date last_modified;

    @ManyToOne (fetch = FetchType.LAZY , cascade = {CascadeType.ALL} )
    @JoinColumn (name = "idQuizType")
    private QuizType quizType;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set <Question> questions;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set <QuizRules> quizRules;

    public Quiz() {
    }

    public Integer getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(Integer idQuiz) {
        this.idQuiz = idQuiz;
    }

    public String getJudulQuiz() {
        return judulQuiz;
    }

    public void setJudulQuiz(String judulQuiz) {
        this.judulQuiz = judulQuiz;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public QuizType getQuizType() {
        return quizType;
    }

    public int getQuizId()
    {
        return quizType.getIdQuizType();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setQuizType(QuizType quizType) {
        this.quizType = quizType;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<QuizRules> getQuizRules() {
        return quizRules;
    }

    public void setQuizRules(Set<QuizRules> quizRules) {
        this.quizRules = quizRules;
    }

    @PreUpdate
    void lastModified() {
        this.last_modified = new Date();
    }

    @PrePersist
    void draftDate(){
        this.draft_date = this.last_modified = new Date();
    }

    public Date getPublished_date() {
        return published_date;
    }

    public void setPublished_date(Date published_date) {
        this.published_date = published_date;
    }
}
