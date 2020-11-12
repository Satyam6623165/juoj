package com.onlineJudge.juoj.controller;

import com.onlineJudge.juoj.constant.RequestConstants;
import com.onlineJudge.juoj.constant.Route;
import com.onlineJudge.juoj.enums.Languages;
import com.onlineJudge.juoj.request.CodeEvaluationRequest;
import com.onlineJudge.juoj.response.CodeEvaluationResponse;
import com.onlineJudge.juoj.response.GetUserResponse;
import com.onlineJudge.juoj.service.CodeEvaluationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class CodeEvaluationController {
    private static final Logger log = LogManager.getLogger(CodeEvaluationController.class);

    @Autowired
    private CodeEvaluationService codeEvaluationService;

    @PostMapping(path = Route.SUBMIT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
    public CodeEvaluationResponse evaluateCode(
            @RequestParam(value = "compileLang") Languages compileLang,
            @RequestParam(value = "timeLimit") double timeLimit,
            @RequestBody String code) {
        log.info("request body: {}", code);
        CodeEvaluationRequest codeEvaluationRequest = new CodeEvaluationRequest(code, compileLang, timeLimit);
        return codeEvaluationService.getVerdict(codeEvaluationRequest);
    }
}
