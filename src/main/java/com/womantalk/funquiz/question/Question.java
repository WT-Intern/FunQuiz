package com.womantalk.funquiz.question;

import com.womantalk.funquiz.option.Option;
import com.womantalk.funquiz.quiz.Quiz;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name = "t_question")
public class Question
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name= "id_question", columnDefinition = "serial")
    private Integer idQuestion;


    private String question;

    private String imageURL;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "id_quiz")
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

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
