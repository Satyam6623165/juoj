package com.onlineJudge.juoj.service;

import com.onlineJudge.juoj.response.GetUserResponse;

public interface UserService {
    public GetUserResponse getUser(String name);
}
