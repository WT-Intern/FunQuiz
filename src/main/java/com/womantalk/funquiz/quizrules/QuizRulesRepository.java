package com.womantalk.funquiz.QuizRules;


import com.womantalk.funquiz.QuizRules.QuizRules;

import java.util.List;

public interface QuizRulesRepository {

    QuizRules findOne(int id_rules);

    QuizRules add(QuizRules quizRules);

    List<QuizRules> findAll();

    int update(QuizRules quizRules);

    int delete(QuizRules quizRules);
}
