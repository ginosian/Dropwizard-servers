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

import javax.inject.Singleton;
import java.util.List;

@Singleton
public abstract class UserServiceImpl implements UserService {

    @CreateSqlObject
    abstract UserDao userDao();

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private final UserMapper userMapper = new UserMapper();

    @Override
    public User get(final Long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void create(final UserCreationRequest userCreationRequest) {
        final User user = mapperFactory.getMapperFacade().map(userCreationRequest, User.class);
        userDao().insert(user.getId(), user.getName());
    }

    @Override
    public void update(final UserUpdateRequest userUpdateRequest) {
    }

    @Override
    public void delete(final Long id) {
    }
}
