package com.womantalk.funquiz.quizrules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class QuizRulesServiceImpl implements QuizRulesService {

    @Autowired
    private QuizRulesRepository quizRulesRepository;

    @Override
    public QuizRules addQuizRules(QuizRules quiz_rules, MultipartFile fileResult) {
        if(!fileResult.isEmpty())
        {
            quiz_rules.setImageURL(fileResult.getOriginalFilename());
            String name = fileResult.getOriginalFilename();
            try{
                byte[] bytes = fileResult.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File("C:/Users/gloria/Documents/GVM/image/result/"+name)));
                stream.write(bytes);
                stream.close();
            }catch (Exception e)
            {
                return null;
            }
        }
        return quizRulesRepository.save(quiz_rules);
    }

    @Override
    public QuizRules findQuizRulesById(int id_rules) {
        return quizRulesRepository.findOne(id_rules);
    }

    @Override
    public List<QuizRules> getAllQuizRules() {
        List<QuizRules> quizRulesList = quizRulesRepository.findAll();
        if(quizRulesList!=null) {
            return quizRulesList;
        }else {
            return null;
        }
    }


    @Override
    public QuizRules updateQuizRules(QuizRules quiz_rules) {
        QuizRules quizRulesUpdate = findQuizRulesById(quiz_rules.getIdRules());
        quizRulesUpdate.setDescription(quiz_rules.getDescription());
        quizRulesUpdate.setMax(quiz_rules.getMax());
        quizRulesUpdate.setMin(quiz_rules.getMin());
        quizRulesUpdate.setValue(quiz_rules.getValue());
        quizRulesUpdate.setQuiz(quiz_rules.getQuiz());
        return quizRulesRepository.saveAndFlush(quizRulesUpdate);
    }
}
