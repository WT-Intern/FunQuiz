package com.womantalk.funquiz.Option;

import java.util.List;

public interface OptionRepository {

    Option findOne(int id_option);

    Option add(Option option);

    List<Option> findAll();

    int update(Option option);

    int delete(Option option);
}
