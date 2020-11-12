package com.onlineJudge.juoj.service.impl;

import com.onlineJudge.juoj.entity.User;
import com.onlineJudge.juoj.response.GetUserResponse;
import com.onlineJudge.juoj.service.UserService;
import com.onlineJudge.juoj.service.db.UserDbService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDbService userDbService;

    @Override
    public GetUserResponse getUser(String name) {
        GetUserResponse response = new GetUserResponse();
        Optional<User> userData = userDbService.findByName(name);
        if(userData.isPresent()) {
            User user = userData.get();
            response = new GetUserResponse(user.getId(), user.getName(), user.getEmail());
        }

        return response;
    }
}
