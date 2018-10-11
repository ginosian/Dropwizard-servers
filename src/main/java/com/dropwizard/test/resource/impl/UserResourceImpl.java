package com.dropwizard.test.resource.impl;

import com.dropwizard.test.core.request.UserCreationRequestDto;
import com.dropwizard.test.core.request.UserUpdateRequestDto;
import com.dropwizard.test.core.responce.ApiResponse;
import com.dropwizard.test.core.responce.ApiSuccessResponce;
import com.dropwizard.test.core.responce.dto.UserDto;
import com.dropwizard.test.resource.UserResource;
import com.dropwizard.test.service.UserService;

public class UserResourceImpl implements UserResource {

    private final UserService userService;

    public UserResourceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ApiResponse<UserDto> get(String userId) {
        return null;
    }

    @Override
    public ApiResponse<UserDto> getALL() {
        return null;
    }

    @Override
    public ApiResponse<ApiSuccessResponce> create(UserCreationRequestDto userCreationRequestDto) {
        return null;
    }

    @Override
    public ApiResponse<ApiSuccessResponce> update(UserUpdateRequestDto userUpdateRequestDto) {
        return null;
    }

    @Override
    public ApiResponse<ApiSuccessResponce> delete(String userId) {
        return null;
    }
}
