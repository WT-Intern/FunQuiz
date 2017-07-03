package com.womantalk.funquiz.Quiz;

import com.womantalk.funquiz.Quiz.Quiz;

import java.util.List;

public interface QuizService {
    void save (Quiz quiz);
    Quiz findById (int id);
    List<Quiz> getAllQuiz();
}
