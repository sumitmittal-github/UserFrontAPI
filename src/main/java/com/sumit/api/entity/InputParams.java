package com.sumit.api.entity;

import org.springframework.stereotype.Component;

@Component
public class InputParams {

    private Long firstNum;
    private Long secondNum;

    @Override
    public String toString() {
        return "InputParams{" +
                "firstNum=" + firstNum +
                ", secondNum=" + secondNum +
                '}';
    }

    public InputParams() {
    }

    public InputParams(Long firstNum, Long secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public Long getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(Long firstNum) {
        this.firstNum = firstNum;
    }

    public Long getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(Long secondNum) {
        this.secondNum = secondNum;
    }
}