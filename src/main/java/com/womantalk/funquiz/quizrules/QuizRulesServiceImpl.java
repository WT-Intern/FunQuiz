package com.womantalk.funquiz.QuizRules;

import com.womantalk.funquiz.QuizRules.QuizRules;
import com.womantalk.funquiz.QuizRules.QuizRulesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuizRulesServiceImpl implements QuizRulesService {
    @Autowired
    private QuizRulesRepository quizRulesRepository;

    @Override
    public void save(QuizRules quizrules) {
        quizRulesRepository.save(quizrules);
    }

    @Override
    public QuizRules findById(int id) {
        return quizRulesRepository.findById(id);
    }

    @Override
    public List<QuizRules> getAllQuizRules() {
        return quizRulesRepository.getAllQuizRules();
    }
}
