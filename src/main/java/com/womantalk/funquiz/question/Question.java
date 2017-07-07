package com.womantalk.funquiz.Question;

import com.womantalk.funquiz.Option.Option;
import com.womantalk.funquiz.Quiz.Quiz;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name = "t_question")
public class Question
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (columnDefinition = "serial")
    private Integer idQuestion;

    @Column
    private String question;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "idQuiz")
    private Quiz quiz;

    @OneToMany (mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set <Option> options;

    public Question() {
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}
