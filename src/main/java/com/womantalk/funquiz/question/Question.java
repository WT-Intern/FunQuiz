package com.womantalk.funquiz.question;

import com.fasterxml.jackson.annotation.JsonView;
import com.womantalk.funquiz.option.Option;
import com.womantalk.funquiz.quiz.Quiz;
import com.womantalk.funquiz.tools.View;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name = "t_question")
public class Question
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name= "id_question", columnDefinition = "serial")
    @JsonView(View.Public.class)
    private Integer idQuestion;

  //  @Column (name ="question")
    @JsonView(View.Public.class)
    private String text;

    @JsonView(View.Public.class)
    private String imageURL;


    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "id_quiz")
    private Quiz quiz;

    @OneToMany (mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonView(View.Public.class)
    private List<Option> options;

    public Question() {
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL)
    {
        this.imageURL = imageURL;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
