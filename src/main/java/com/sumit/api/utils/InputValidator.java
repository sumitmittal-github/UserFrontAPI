package com.sumit.api.utils;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InputValidator {

    public String validateAddAllInput(List<Long> inputs){
        if(inputs == null || inputs.size()<2)
            return "please provide at least 2 numbers";
        else
            return null;
    }

}