package com.womantalk.funquiz.quizrules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizRulesServiceImpl implements QuizRulesService {

    @Autowired
    private QuizRulesRepository quizRulesRepository;


    @Override
    public QuizRules save(QuizRules quiz_rules) {
        return quizRulesRepository.save(quiz_rules);
    }

    @Override
    public QuizRules findOne(int id_rules) {
        return quizRulesRepository.findOne(id_rules);
    }

    @Override
    public List<QuizRules> findAll() {
        List<QuizRules> quizRulesList = quizRulesRepository.findAll();
        if(quizRulesList!=null) {
            return quizRulesList;
        }else {
            return null;
        }
    }

    @Override
    public QuizRules delete(int id_rules) {
        QuizRules quizRules = findOne(id_rules);
        if(quizRules!=null){
            quizRulesRepository.delete(id_rules);
            return quizRules;
        }else {
            return null;
        }
    }

    @Override
    public QuizRules update(QuizRules quiz_rules) {
        QuizRules quizRulesUpdate = findOne(quiz_rules.getIdRules());
        quizRulesUpdate.setDescription(quiz_rules.getDescription());
        quizRulesUpdate.setMax(quiz_rules.getMax());
        quizRulesUpdate.setMin(quiz_rules.getMin());
        quizRulesUpdate.setValue(quiz_rules.getValue());
        quizRulesUpdate.setQuiz(quiz_rules.getQuiz());
        return quizRulesRepository.saveAndFlush(quizRulesUpdate);
    }
}
