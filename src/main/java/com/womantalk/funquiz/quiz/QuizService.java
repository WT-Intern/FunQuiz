package com.womantalk.funquiz.Quiz;

import com.womantalk.funquiz.Quiz.Quiz;

import java.util.List;

public interface QuizService {
    Quiz save (Quiz quiz);
    Quiz findById (int id);
    List<Quiz> findAll();
    void deleteById (int id);
    Quiz update (Quiz quiz);
}
