package com.womantalk.funquiz.option;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OptionService
{
    List<Option> getOptionByIdQuestion(int id);
    Option addOption (Option option);
    List<Option> getAllOption();
    Option findOptionById(int id_option);
    Option updateOption(Option option);

    //List<Option> createOption(List<Option> options);
}
