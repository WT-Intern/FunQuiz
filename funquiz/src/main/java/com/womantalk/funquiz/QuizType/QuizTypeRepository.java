package com.womantalk.funquiz.QuizType;

import com.womantalk.funquiz.QuizType.QuizType;

import java.util.List;

public interface QuizTypeRepository {
    void save (QuizType quiztype);
    QuizType findById (int id);
    List<QuizType> getAllQuizType();

}
