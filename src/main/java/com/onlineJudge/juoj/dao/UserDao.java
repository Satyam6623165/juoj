package com.onlineJudge.juoj.dao;

import com.onlineJudge.juoj.entity.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserDao extends CrudRepository<User, Integer> {
    Optional<User> findByName(String name);
}
