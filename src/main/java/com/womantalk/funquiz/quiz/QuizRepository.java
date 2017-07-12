package com.womantalk.funquiz.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gloria on 07/07/2017.
 */


@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>
{
  //List<Quiz> findAllByQuizType_IdQuizType (int IdQuizType);

}
