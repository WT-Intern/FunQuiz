package com.womantalk.funquiz.quiztype;

public class QuizTypeQuery {

    //Display all Quiz Type
    public static final String ALL_QUIZ_TYPE = "SELECT * FROM t_quiz_type ";

    //Display Quiz Type by Id
    public static final String QUIZ_TYPE_BY_ID = "SELECT * FROM t_quiz_type WHERE id_quiz_type =?";

    //Add Quiz Type
    public static final String INSERT_QUIZ_TYPE = "INSERT INTO t_quiz_type(id_quiz_type, type_name)VALUES (?,?)";

    //Update Quiz Type by Id
    public static final String UPDATE_QUIZ_TYPE = "UPDATE t_quiz_type SET type_name=? WHERE id_quiz_type =?";

    //Delete Quiz Type by Id
    public static final String DELETE_QUIZ_TYPE = "DELETE FROM t_quiz_type WHERE id_quiz_type=?";

}
