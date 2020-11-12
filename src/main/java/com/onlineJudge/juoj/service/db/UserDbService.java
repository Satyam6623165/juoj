package com.onlineJudge.juoj.service.db;

import com.onlineJudge.juoj.entity.User;
import java.util.Optional;

public interface UserDbService {
    public Optional<User> findByName(String name);
}
