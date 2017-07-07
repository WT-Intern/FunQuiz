package com.womantalk.funquiz.QuizRules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizRulesServiceImpl implements QuizRulesService {

    @Autowired
    QuizRulesRepository quizRulesRepository;

    @Override
    public QuizRules findOne(int id_rules) {
        return quizRulesRepository.findOne(id_rules);
    }

    @Override
    public QuizRules add(QuizRules quizRules) {
        return null;
    }

    @Override
    public List<QuizRules> findAll() {
        return quizRulesRepository.findAll();
    }

    @Override
    public int update(QuizRules quizRules) {
        return 0;
    }

    @Override
    public int delete(QuizRules quizRules) {
        return 0;
    }
}
