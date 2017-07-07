package com.womantalk.funquiz.Option;

/**
 * Created by gloria on 03/07/2017.
 */
public class OptionQuery {

    //Display all Option
    public static final String ALL_OPTION = "SELECT * FROM t_option ORDER BY id_option ASC ";

    //Display Option by Id
    public static final String OPTION_BY_ID = "SELECT * FROM t_option WHERE id_option = ?";

    //Add Option
    public static final String INSERT_OPTION = "INSERT INTO t_option(id_option, imageurl, text, type, value, id_question)VALUES (?, ?, ?, ?, ?, ?)";

    //Update Option by Id
    public static final String UPDATE_OPTION = "UPDATE t_option SET imageurl=?, text=?, type=?, value=?, id_question WHERE id_option=?";

    //Delete Option  by Id
    public static final String DELETE_OPTION = "DELETE FROM t_option WHERE id_option=?";
}
