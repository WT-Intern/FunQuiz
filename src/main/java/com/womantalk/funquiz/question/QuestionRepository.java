package com.womantalk.funquiz.Question;

import com.womantalk.funquiz.Question.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionRepository extends JpaRepository <Question, Integer>
{
    @Query( "select a from t_question a where a.idQuiz = :idQuiz")
    List<Question> getAllQuestionByIdQuiz (Integer idQuiz);
}

