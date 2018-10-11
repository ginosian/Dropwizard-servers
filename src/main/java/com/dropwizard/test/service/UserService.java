package com.dropwizard.test.service;

import com.dropwizard.test.core.entity.User;
import com.dropwizard.test.service.model.UserCreationRequest;
import com.dropwizard.test.service.model.UserUpdateRequest;

import java.util.List;

public interface UserService {

    User get(Long id);

    List<User> getAll();

    void create(UserCreationRequest userCreationRequest);

    void update(UserUpdateRequest userUpdateRequest);

    void delete(Long id);
}
