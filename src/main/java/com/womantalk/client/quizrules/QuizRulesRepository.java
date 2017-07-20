package com.womantalk.client.quizrules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRulesRepository extends JpaRepository<QuizRules, Integer>
{
    List<QuizRules> findQuizRulesByQuiz_IdQuiz(int id);
}
