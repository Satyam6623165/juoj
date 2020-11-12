package com.onlineJudge.juoj.service;

import com.onlineJudge.juoj.request.CodeEvaluationRequest;
import com.onlineJudge.juoj.response.CodeEvaluationResponse;

public interface CodeEvaluationService {
    CodeEvaluationResponse getVerdict(CodeEvaluationRequest codeEvaluationRequest);
}
