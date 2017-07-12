package com.womantalk.funquiz.quizrules;


import java.util.List;

public interface QuizRulesService {

    QuizRules save(QuizRules quiz_rules);
    QuizRules findOne(int id_rules);
    List<QuizRules> findAll();
    QuizRules delete(int id_rules);
    QuizRules update(QuizRules quiz_rules);
}
