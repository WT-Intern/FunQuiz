package com.womantalk.funquiz.Option;

import org.springframework.stereotype.Repository;

@Repository
public class OptionQuery {
    public static final String SQL_INSERT = "insert into t_option (idOption, text, imageURL, type, value, idQuestion) values (?, ?, ?, ?, ?, ?)";
    public static final String SQL_FIND_BY_ID = "select * from t_option where idOption = ?";
    public static final String SQL_GET_ALL = "select * from t_option";

}
