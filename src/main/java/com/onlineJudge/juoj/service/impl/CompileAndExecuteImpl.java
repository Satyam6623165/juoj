package com.onlineJudge.juoj.service.impl;

import com.onlineJudge.juoj.constant.Constant;
import com.onlineJudge.juoj.enums.Languages;
import com.onlineJudge.juoj.enums.Verdict;
import com.onlineJudge.juoj.service.CompileAndExecute;
import com.onlineJudge.juoj.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.concurrent.TimeUnit;

@Service
public class CompileAndExecuteImpl implements CompileAndExecute {

    private static final Logger log = LogManager.getLogger(CompileAndExecuteImpl.class);

    @Override
    public Verdict compile(Languages lang, String tempFilePath) {
        log.info("Code compilation started!!");

        ProcessBuilder p = null;
        boolean compiled = true;
        int exitCode = 0;

        if (lang.getValue().equals(Languages.JAVA.getValue())) {
            p = new ProcessBuilder("javac", tempFilePath + ".java");
        } else if (lang.getValue().equals(Languages.C.getValue())) {
            p = new ProcessBuilder("gcc","-std=c++0x","-w","-o", tempFilePath, tempFilePath + ".c");
        } else if(lang.getValue().equals(Languages.CPP.getValue())){
            p = new ProcessBuilder("g++","-std=c++0x","-w", "-o", tempFilePath, tempFilePath + ".cpp");
        } else {
            return Verdict.CS;
        }
        p.redirectErrorStream(true);

        try {
            Process pp = p.start();
            InputStream is = pp.getInputStream();
            String temp;
            BufferedReader b = new BufferedReader(new InputStreamReader(is));
            while ((temp = b.readLine()) != null) {
                compiled = false;
                System.out.println(temp);
            }
            exitCode = pp.waitFor();

            if (!compiled) {
                is.close();
                log.info("Code Compilation Failed with exit code: {}", exitCode);
                return Verdict.CE;
            }
            is.close();
            log.info("Code Compilation Finished with exit code: {}", exitCode);
            return Verdict.CS;
        } catch (InterruptedException | IOException e) {
            log.error("Error: {}", Utils.exceptionFormatter(e));
        }

        log.info("Code Compilation Failed with exit code: {}", exitCode);
        return Verdict.CE;
    }

    @Override
    public Verdict execute(Languages lang, String inputFilePath, String tempFilePath, double timeLimit) {
        log.info("Code started executing!!");

        ProcessBuilder p = null;
        if (lang.getValue().equals(Languages.JAVA.getValue())) {
            p = new ProcessBuilder("java", "tempSol");
        } else if (lang.getValue().equals(Languages.C.getValue())
                || lang.getValue().equals(Languages.CPP.getValue())) {
            p = new ProcessBuilder(".\\tempSol");
        } else if(lang.getValue().equals(Languages.PYTHON2.getValue())){
            p = new ProcessBuilder("python2", "tempSol.py");
        } else if(lang.getValue().equals(Languages.PYTHON3.getValue())){
            p = new ProcessBuilder("python3", "tempSol.py");
        }
        p.directory(new File("C:\\Users\\skdav\\OneDrive\\Desktop"));

        File in = new File(inputFilePath);
        p.redirectInput(in);
        p.redirectErrorStream(true);

        File out = new File(Constant.outputFilePath);
        p.redirectOutput(out);

        try {

            Process pp = p.start();
            if (!pp.waitFor((long)timeLimit * 1000, TimeUnit.MILLISECONDS)) {
                return Verdict.TLE;
            }
            int exitCode = pp.exitValue();
            if(exitCode != 0)
                return Verdict.RE;
        } catch (IOException | InterruptedException | NullPointerException e) {
            log.error("Error: {}", Utils.exceptionFormatter(e));
        }
        log.info("Code execution finished!!");
        return Verdict.RS;
    }
}
