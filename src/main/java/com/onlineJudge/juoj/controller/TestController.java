package com.onlineJudge.juoj.controller;

import com.onlineJudge.juoj.constant.RequestConstants;
import com.onlineJudge.juoj.constant.Route;
import com.onlineJudge.juoj.response.GetUserResponse;
import com.onlineJudge.juoj.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Validated
public class TestController {
    private static final Logger log = LogManager.getLogger(TestController.class);

    @Autowired
    private UserService userService;

    @GetMapping(path = Route.TEST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GetUserResponse testApi(
            @RequestParam(value = RequestConstants.NAME) String name) {
        log.info("request param: {}", name);
        return userService.getUser(name);
    }
}
