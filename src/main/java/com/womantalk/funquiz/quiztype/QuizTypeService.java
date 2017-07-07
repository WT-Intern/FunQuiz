package com.womantalk.funquiz.QuizType;

import com.womantalk.funquiz.QuizType.QuizType;

import java.util.List;

public interface QuizTypeService {
    QuizType save (QuizType quiztype);
    QuizType findById (int id);
    List<QuizType> findAll();
    void deleteById (int id);
    QuizType update (QuizType quizType);
}
