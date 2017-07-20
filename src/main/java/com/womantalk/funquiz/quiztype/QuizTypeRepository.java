package com.womantalk.funquiz.quiztype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuizTypeRepository extends JpaRepository<QuizType, Integer> {

}
