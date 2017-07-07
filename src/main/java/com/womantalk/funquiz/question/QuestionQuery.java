package com.womantalk.funquiz.Question;

/**
 * Created by gloria on 03/07/2017.
 */
public class QuestionQuery {

    //Display all Question
    public static final String ALL_QUESTION = "SELECT * FROM t_option ORDER BY id_option ASC";

    //Display Question by Id
    public static final String QUESTION_BY_ID = "SELECT * FROM t_option WHERE id_option = ?";

    //Add Question
    public static final String INSERT_QUESTION = "INSERT INTO t_option( imageurl, text, type, value, id_question) VALUES (?, ?, ?, ?, ?)";

    //Update Question
    public static final String UPDATE_QUESTION = "UPDATE t_option SET id_option, imageurl=?, text=?, type=?, value=?, id_question WHERE id_option=?;";

    //Delete Question
    public static final String DELETE_QUESTION = "DELETE FROM t_option WHERE id_optioon=?";
}
