package com.womantalk.funquiz.question;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QuestionService
{
    List<Question> getQuestionByIdQuiz(int id);
    Question addQuestion(Question question, @RequestParam("fileQuestion") MultipartFile fileQuestion);
    List<Question> getAllQuestion();
    Question findQuestionById(int id_question);
    Question updateQuestion (Question question);
}
