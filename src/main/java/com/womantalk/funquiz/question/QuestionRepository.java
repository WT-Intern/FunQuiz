package com.womantalk.funquiz.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository <Question, Integer>
{

    List <Question> findAllByQuiz_IdQuiz(int id_quiz);

}
