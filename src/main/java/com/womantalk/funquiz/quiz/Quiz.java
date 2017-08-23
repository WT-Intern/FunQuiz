package com.womantalk.funquiz.quiz;

import com.fasterxml.jackson.annotation.JsonView;
import com.womantalk.funquiz.question.Question;
import com.womantalk.funquiz.quizrules.QuizRules;
import com.womantalk.funquiz.quiztype.QuizType;
import com.womantalk.funquiz.tools.View;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name ="t_quiz")
public class Quiz
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (columnDefinition = "serial")
    @JsonView(View.Public.class)
    private Integer idQuiz;

    @Column
    @JsonView(View.Public.class)
    private String judulQuiz;

    @Column
    private String imageURL;

    @Column
    @JsonView(View.Public.class)
    private Integer total_question;

    @JsonView(View.Public.class)
    private String status;

    @JsonView(View.Public.class)
    public String created_date;

   // @Temporal(TemporalType.TIMESTAMP)
    @JsonView(View.Public.class)
    public String published_date;

  //  @Temporal(TemporalType.TIMESTAMP)
    @JsonView(View.Public.class)
    public String modified_date;

    @ManyToOne (fetch = FetchType.LAZY  )
    @JoinColumn (name = "idQuizType")
    @JsonView(View.Public.class)
    private QuizType quizType;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonView(View.Public.class)
    private List<Question> questions;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonView(View.Public.class)
    private List<QuizRules> quizRules;

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

    public void setImageURL(String imageURL)
    {
        this.imageURL = imageURL;
    }

    public Integer getTotal_question() {
        return total_question;
    }

    public void setTotal_question(Integer total_question) {
        this.total_question = total_question;
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<QuizRules> getQuizRules() {
        return quizRules;
    }

    public void setQuizRules(List<QuizRules> quizRules) {
        this.quizRules = quizRules;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getModified_date() {
        return modified_date;
    }

    public void setModified_date(String modified_date) {
        this.modified_date = modified_date;
    }

   /* @PrePersist
    @PreUpdate
    void modifiedDate() {
        this.modified_date = new Date();
    }*/
}
