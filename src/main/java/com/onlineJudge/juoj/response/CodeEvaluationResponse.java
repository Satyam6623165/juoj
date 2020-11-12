package com.onlineJudge.juoj.response;

import com.onlineJudge.juoj.enums.Verdict;

public class CodeEvaluationResponse {
    private Verdict verdict;

    public CodeEvaluationResponse() {}

    public CodeEvaluationResponse(Verdict verdict) {
        this.verdict = verdict;
    }

    public Verdict getVerdict() {
        return verdict;
    }

    @Override
    public String toString() {
        return "CodeEvaluationResponse{" +
                "verdict=" + verdict +
                '}';
    }
}
