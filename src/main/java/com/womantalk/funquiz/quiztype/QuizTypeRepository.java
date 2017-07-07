package com.womantalk.funquiz.quiztype;

import com.womantalk.funquiz.quiztype.QuizType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizTypeRepository extends JpaRepository<QuizType, Integer> {

}
