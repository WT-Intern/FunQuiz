package com.womantalk.client.question;

import com.fasterxml.jackson.annotation.JsonView;
import com.womantalk.client.option.Option;
import com.womantalk.client.quiz.Quiz;
import com.womantalk.client.tools.View;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name = "t_question")
public class Question
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (columnDefinition = "serial")
    @JsonView (View.AllQuiz.class)
    private Integer idQuestion;

    @Column
    @JsonView (View.AllQuiz.class)
    private String text;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "idQuiz")
    //@JsonIgnore
    private Quiz quiz;

    @JsonView (View.AllQuiz.class)
    @OneToMany (mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set <Option> options;

    public Question()
    {

    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
