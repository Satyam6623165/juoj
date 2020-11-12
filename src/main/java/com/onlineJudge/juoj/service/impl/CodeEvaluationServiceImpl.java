package com.onlineJudge.juoj.service.impl;

import com.onlineJudge.juoj.constant.Constant;
import com.onlineJudge.juoj.enums.Languages;
import com.onlineJudge.juoj.enums.Verdict;
import com.onlineJudge.juoj.request.CodeEvaluationRequest;
import com.onlineJudge.juoj.response.CodeEvaluationResponse;
import com.onlineJudge.juoj.service.CodeEvaluationService;
import com.onlineJudge.juoj.service.CompileAndExecute;
import com.onlineJudge.juoj.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class CodeEvaluationServiceImpl implements CodeEvaluationService {

    private Logger log = LogManager.getLogger(CodeEvaluationServiceImpl.class);

    @Autowired
    private CompileAndExecute compileAndExecute;

    @Override
    public CodeEvaluationResponse getVerdict(CodeEvaluationRequest codeEvaluationRequest) {

        String code = codeEvaluationRequest.getCode();
        Languages compileLang = codeEvaluationRequest.getCompileLang();
        double timeLimit = codeEvaluationRequest.getTimeLimit();

        String tempSourceFilePath = Constant.tempSourceFilePath;
        switch(compileLang) {
            case C:
                tempSourceFilePath = tempSourceFilePath.concat(Constant.cExt);
                break;
            case CPP:
                tempSourceFilePath = tempSourceFilePath.concat(Constant.cppExt);
                break;
            case JAVA:
                tempSourceFilePath = tempSourceFilePath.concat(Constant.javaExt);
                break;
            case PYTHON2:
            case PYTHON3:
                tempSourceFilePath = tempSourceFilePath.concat(Constant.pythonExt);
                break;
            default: break;
        }

        try {
            FileWriter fw = new FileWriter(tempSourceFilePath);
            fw.write(code);
            fw.close();
        } catch(IOException e) {
            log.error("Error: {}", Utils.exceptionFormatter(e));
        }

        Verdict verdict = compileAndExecute.compile(compileLang, Constant.tempSourceFilePath);
        if(Verdict.CS.getValue().equals(verdict.getValue())) {
            verdict = compileAndExecute.execute(compileLang, Constant.inputFilePath, Constant.tempSourceFilePath, timeLimit);
        }
        CodeEvaluationResponse response = new CodeEvaluationResponse(verdict);
        return response;
    }
}
