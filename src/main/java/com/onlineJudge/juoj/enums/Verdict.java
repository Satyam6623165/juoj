package com.onlineJudge.juoj.enums;

public enum Verdict {
    AC("Accepted"),
    WA("Wrong Answer"),
    TLE("Time Limit Exceeded"),
    SIGBART("Segmentation Fault"),
    RE("Runtime Error"),
    RS("Run Success"),
    CE("Compilation Error"),
    CS("Compilation success");

    private String value;

    Verdict(String value) { this.value = value; }

    public String getValue() {
        return value;
    }
}
