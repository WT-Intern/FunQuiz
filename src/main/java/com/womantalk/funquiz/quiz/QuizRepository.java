package com.womantalk.funquiz.quiz;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Integer>{

    List<Quiz> findByQuizType(int id);

}
