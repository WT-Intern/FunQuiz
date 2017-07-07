package com.womantalk.funquiz.Question;


import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository {

    @Query( "select a from t_question a where a.idQuiz = :idQuiz")
    List<Question> getAllQuestionByIdQuiz (Integer idQuiz);


}
