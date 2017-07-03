package com.womantalk.funquiz.quiztype;


import java.util.List;

public interface QuizTypeService {

    QuizType findOne(int id_quiz_type);

    QuizType add(QuizType quizType);

    List<QuizType> findAll();

    int update(QuizType quizType);

    int delete(QuizType quizType);
}