package com.womantalk.funquiz.Option;

import com.womantalk.funquiz.Option.Option;

import java.util.List;

public interface OptionRepository {
    void save (Option option);
    Option findById (int id);
    List<Option> getAllOption();
}
