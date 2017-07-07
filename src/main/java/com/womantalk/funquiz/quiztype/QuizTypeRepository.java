package com.womantalk.funquiz.quiztype;

import com.womantalk.funquiz.quiztype.QuizType;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import java.util.List;

=======
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
>>>>>>> 6825a95797fd57f686d42ddf0cefa960619a72b3
public interface QuizTypeRepository extends JpaRepository<QuizType, Integer> {

}
