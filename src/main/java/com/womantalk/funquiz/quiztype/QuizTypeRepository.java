package com.womantalk.funquiz.QuizType;

import com.womantalk.funquiz.QuizType.QuizType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizTypeRepository extends JpaRepository<QuizType, Integer> {

}
