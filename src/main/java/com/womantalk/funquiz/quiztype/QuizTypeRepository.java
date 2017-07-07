package com.womantalk.funquiz.quiztype;

import com.womantalk.funquiz.quiztype.QuizType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizTypeRepository extends JpaRepository<QuizType, Integer> {

}
