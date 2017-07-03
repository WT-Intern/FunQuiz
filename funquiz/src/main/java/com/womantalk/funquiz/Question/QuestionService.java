package com.womantalk.funquiz.Question;

import com.womantalk.funquiz.Question.Question;

import java.util.List;

public interface QuestionService {
    void save (Question question);
    Question findById (int id);
    List<Question> getAllQuestion();
}
