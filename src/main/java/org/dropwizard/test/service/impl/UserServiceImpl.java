package org.dropwizard.test.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.dropwizard.test.core.entity.User;
import org.dropwizard.test.core.mapper.BeanMapper;
import org.dropwizard.test.dao.UserDAO;
import org.dropwizard.test.service.UserService;
import org.dropwizard.test.service.model.UserCreationRequest;
import org.dropwizard.test.service.model.UserUpdateRequest;

import javax.inject.Inject;
import java.util.List;

@Slf4j
public class UserServiceImpl implements UserService {

    private UserDAO userDao;

    @Inject
    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    private final BeanMapper beanMapper = new BeanMapper();

    @Override
    public User get(final Long id) {
        return userDao.get(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User create(final UserCreationRequest userCreationRequest) {
        final User user = beanMapper.map(userCreationRequest, User.class);
        return userDao.insert(user.getId(), user.getName());
    }

    @Override
    public User update(final UserUpdateRequest userUpdateRequest) {
        final User user = beanMapper.map(userUpdateRequest, User.class);
        return userDao.update(user.getId(), user.getName());
    }

    @Override
    public String delete(final Long id) {
        userDao.delete(id, true);
        return String.format("Deletion was successful for User:'%s'.", id);
    }

    @Override
    public String performHealthCheck() {
        try {
            userDao.getAll();
        } catch (Exception ex) {
            return "Database error" + ex.getCause().getLocalizedMessage();
        }
        return null;
    }
}
