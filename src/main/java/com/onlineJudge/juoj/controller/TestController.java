package com.onlineJudge.juoj.controller;

import com.onlineJudge.juoj.constant.RequestConstants;
import com.onlineJudge.juoj.constant.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class TestController {
    private static final Logger log = LogManager.getLogger(TestController.class);

    @GetMapping(path = Route.TEST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String testApi(
            @RequestParam(value = RequestConstants.NAME) String name) {
        log.info("testing api with request param: {}", name);
        return name;
    }
}
