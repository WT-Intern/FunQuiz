package com.womantalk.funquiz.quiztype;

import com.womantalk.funquiz.quiztype.QuizType;

import java.util.List;

public interface QuizTypeService {
    QuizType save(QuizType quiztype);
    QuizType findById(int id);
    List<QuizType> findAll();
    void deleteById(int id);
    QuizType update(QuizType quizType);
}
