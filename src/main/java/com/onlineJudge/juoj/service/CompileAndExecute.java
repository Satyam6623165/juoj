package com.onlineJudge.juoj.service;

import com.onlineJudge.juoj.enums.Languages;
import com.onlineJudge.juoj.enums.Verdict;

public interface CompileAndExecute {
    Verdict compile(Languages lang, String tempFilePath);
    Verdict execute(Languages lang, String inputFilePath, String tempFilePath, double timeLimit);
}
