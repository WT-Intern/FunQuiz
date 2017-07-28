package com.womantalk.funquiz.quizrules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuizRulesRepository extends JpaRepository<QuizRules, Integer>{

    List<QuizRules> findAllByQuiz_IdQuiz(int id);
}
