package com.womantalk.funquiz.Quiz;

/**
 * Created by gloria on 03/07/2017.
 */
public class QuizQuery {

    //Display all Quiz
    public static final String ALL_QUIZ = "SELECT * FROM t_quiz ORDER BY id_quiz ASC";

    //Display Quiz by Id
    public static final String QUIZ_BY_ID = "SELECT * FROM t_quiz WHERE id_quiz = ?";

    //Add Quiz
    public static final String INSERT_QUIZ = "INSERT INTO t_quiz(judul_quiz, id_quiz_type)VALUES (?, ?)";

    //Update Quiz by Id
    public static final String UPDATE_QUIZ = "UPDATE t_quiz SET id_quiz, judul_quiz=?, id_quiz_type WHERE id_quiz=?";

    //Delete Quiz by Id
    public static final String DELETE_QUIZ = "DELETE FROM t_quiz WHERE id_quiz=?";
        }
