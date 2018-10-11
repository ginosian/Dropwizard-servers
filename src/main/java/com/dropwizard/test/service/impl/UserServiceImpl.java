package com.dropwizard.test.service.impl;

import com.dropwizard.test.core.entity.User;
import com.dropwizard.test.dao.UserDao;
import com.dropwizard.test.dao.mapper.UserMapper;
import com.dropwizard.test.service.UserService;
import com.dropwizard.test.service.model.UserCreationRequest;
import com.dropwizard.test.service.model.UserUpdateRequest;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.jdbi.v3.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class UserServiceImpl implements UserService {

    @CreateSqlObject
    abstract UserDao partsDao();

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private final UserMapper userMapper = new UserMapper();

    @Override
    public User get(String id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void create(UserCreationRequest userCreationRequest) {
    }

    @Override
    public void update(UserUpdateRequest userUpdateRequest) {
    }

    @Override
    public void delete(String id) {
    }
}
