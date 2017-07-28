package com.womantalk.funquiz.quizrules;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QuizRulesService {

    QuizRules addQuizRules(QuizRules quiz_rules, @RequestParam("fileResult")MultipartFile fileResult);
    QuizRules findQuizRulesById(int id_rules);
    List<QuizRules> getAllQuizRules();
    QuizRules updateQuizRules(QuizRules quiz_rules);
}
