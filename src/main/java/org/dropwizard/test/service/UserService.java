package org.dropwizard.test.service;

import org.dropwizard.test.core.entity.User;
import org.dropwizard.test.service.model.UserCreationRequest;
import org.dropwizard.test.service.model.UserUpdateRequest;

import java.util.List;

//@Contract
public interface UserService {

    User get(Long id);

    List<User> getAll();

    void create(UserCreationRequest userCreationRequest);

    void update(UserUpdateRequest userUpdateRequest);

    void delete(Long id);

    String performHealthCheck();
}
