package com.onlineJudge.juoj.request;

import com.onlineJudge.juoj.enums.Languages;

public class CodeEvaluationRequest {
    private String code;
    private Languages compileLang;
    private double timeLimit;

    public CodeEvaluationRequest() {}

    public CodeEvaluationRequest(String code, Languages compileLang, double timeLimit) {
        this.code = code;
        this.compileLang = compileLang;
        this.timeLimit = timeLimit;
    }

    public String getCode() {
        return code;
    }

    public Languages getCompileLang() {
        return compileLang;
    }

    public double getTimeLimit() {
        return timeLimit;
    }

    @Override
    public String toString() {
        return "CodeEvaluationRequest{" +
                "code='" + code + '\'' +
                ", compileLang=" + compileLang +
                ", timeLimit=" + timeLimit +
                '}';
    }
}
