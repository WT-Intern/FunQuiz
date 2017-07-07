package com.womantalk.funquiz.quizrules;

/**
 * Created by gloria on 03/07/2017.
 */
public class QuizRulesQuery {

    //Display all Quiz Rules
    public static final String ALL_QUIZ_RULES = "SELECT * FROM t_quiz_rules ORDER BY id_rules ASC";

    //Display Quiz Rules by Id
    public static final String QUIZ_RULES_BY_ID = "SELECT * FROM t_quiz_rules WHERE id_rules = ?";

    //Add Quiz Rules
    public static final String INSERT_QUIZ_RULES = "INSERT INTO t_quiz_rules(description, max, min, value, id_quiz)VALUES (?, ?, ?, ?, ?)";

    //Update Quiz Rules by Id
    public static final String UPDATE_QUIZ_RULES = "UPDATE t_quiz_rules SET id_rules, description=?, max=?, min=?, value=?, id_quiz WHERE id_rules=?";

    //Delete Quiz Rules by Id
    public static final String DELETE_QUIZ_RULES = "DELETE FROM t_quiz_rules WHERE id_rules=?";
}
