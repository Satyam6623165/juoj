package com.onlineJudge.juoj.enums;

public enum Languages {

    C("c"),
    CPP("c++"),
    JAVA("java"),
    PYTHON2("python2"),
    PYTHON3("python3");


    private String value;

    Languages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
