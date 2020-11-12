package com.onlineJudge.juoj.service.db.impl;

import com.onlineJudge.juoj.dao.UserDao;
import com.onlineJudge.juoj.entity.User;
import com.onlineJudge.juoj.service.db.UserDbService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDbServiceImpl implements UserDbService {

    private UserDao userDao;

    @Autowired
    public UserDbServiceImpl(@NotNull UserDao userDao) { this.userDao = userDao; }

    @Override
    public Optional<User> findByName(String name) {
        return userDao.findByName(name);
    }
}
