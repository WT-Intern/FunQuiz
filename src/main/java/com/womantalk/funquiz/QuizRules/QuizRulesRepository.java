package com.womantalk.funquiz.QuizRules;

import com.womantalk.funquiz.QuizRules.QuizRules;

import java.util.List;

public interface QuizRulesRepository {
    void save (QuizRules quizrules);
    QuizRules findById (int id);
    List<QuizRules> getAllQuizRules();
}
