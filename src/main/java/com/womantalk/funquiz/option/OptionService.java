package com.womantalk.funquiz.Option;

import com.womantalk.funquiz.Option.Option;

import java.util.List;

public interface OptionService {
    void save (Option option);
    Option findById (int id);
    List<Option> getAllOption();
}
