package com.womantalk.funquiz.Quiz;

import com.womantalk.funquiz.Question.Question;
import com.womantalk.funquiz.QuizRules.QuizRules;
import com.womantalk.funquiz.QuizType.QuizType;

import javax.persistence.*;
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

    @ManyToOne (fetch = FetchType.LAZY)
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

    public QuizType getQuizType() {
        return quizType;
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
}
