package com.womantalk.funquiz.QuizRules;

import com.womantalk.funquiz.QuizRules.QuizRules;

import java.util.List;

public interface QuizRulesService {
    void save (QuizRules quizrules);
    QuizRules findById (int id);
    List<QuizRules> getAllQuizRules();
}
