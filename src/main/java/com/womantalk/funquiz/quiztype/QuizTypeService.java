package com.womantalk.funquiz.quiztype;

import java.util.List;

public interface QuizTypeService {

    QuizType addQuiztype(QuizType quizType);
    QuizType findQuiztypebyId(int id_quiztype);
    List<QuizType> getAllQuiztype();
    QuizType deleteQuiztype(int id_quiztype);
    QuizType updateQuiztype(QuizType quizType);

}
