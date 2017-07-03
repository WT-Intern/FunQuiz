package com.womantalk.funquiz.QuizType;

import com.womantalk.funquiz.QuizType.QuizType;

import java.util.List;

public interface QuizTypeService {
    void save (QuizType quiztype);
    QuizType findById (int id);
    List<QuizType> getAllQuizType();
}
