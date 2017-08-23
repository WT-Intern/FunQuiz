package com.womantalk.funquiz.quizrules;


import java.util.List;

public interface QuizRulesService {

    QuizRules addQuizRules(QuizRules quiz_rules);
    QuizRules findQuizRulesById(int id_rules);
    List<QuizRules> getAllQuizRules();
    QuizRules updateQuizRules(QuizRules quiz_rules);
}
