package com.womantalk.funquiz.question;

import java.util.List;

public interface QuestionService
{
    List<Question> getAllQuestionByIdQuiz(int id);

    Question save(Question question);
}
