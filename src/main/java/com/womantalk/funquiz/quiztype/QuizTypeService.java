package com.womantalk.funquiz.quiztype;


import java.util.List;

public interface QuizTypeService {

    QuizType findOne(int id_quiz_type);

    public void add (QuizType quizType);

    List<QuizType> findAll();

    int update(QuizType quizType);

    void delete(int quizType);
}