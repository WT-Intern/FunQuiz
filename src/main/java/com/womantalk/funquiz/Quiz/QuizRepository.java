package com.womantalk.funquiz.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
