package com.womantalk.funquiz.quizrules;


import java.util.List;

public interface QuizRulesService {

    QuizRules findOne(int id_rules);

    QuizRules add(QuizRules quizRules);

    List<QuizRules> findAll();

    int update(QuizRules quizRules);

    int delete(QuizRules quizRules);
}
