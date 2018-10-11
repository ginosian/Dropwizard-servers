package com.dropwizard.test.resource.impl;

import com.dropwizard.test.core.request.UserCreationRequestDto;
import com.dropwizard.test.core.request.UserUpdateRequestDto;
import com.dropwizard.test.core.responce.ApiErrorResponse;
import com.dropwizard.test.core.responce.ApiResponse;
import com.dropwizard.test.core.responce.ApiSuccessResponse;
import com.dropwizard.test.core.responce.dto.UserDto;
import com.dropwizard.test.resource.UserResource;
import com.dropwizard.test.service.UserService;
import com.dropwizard.test.service.model.UserCreationRequest;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import javax.inject.Inject;

public class UserResourceImpl implements UserResource {

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    @Inject
    private UserService userService;

    @Override
    public ApiResponse<UserDto> get(final String userId) {
        return null;
    }

    @Override
    public ApiResponse<UserDto> getALL() {
        return null;
    }

    @Override
    public ApiResponse<ApiSuccessResponse> create(final UserCreationRequestDto userCreationRequestDto) {
        try {
            userService.create(mapperFactory.getMapperFacade().map(userCreationRequestDto, UserCreationRequest.class));
            final ApiResponse<ApiSuccessResponse> apiResponse = new ApiResponse<>();
            //Add id to log message
            apiResponse.setApiResponse(new ApiSuccessResponse("User successfully created"));
            return apiResponse;
        } catch (Exception e) {
            final ApiResponse<ApiSuccessResponse> apiResponse = new ApiResponse<>();
            //Add id to log message
            apiResponse.setErrorResponse(new ApiErrorResponse("Failed to create user"));
            return apiResponse;
        }
    }

    @Override
    public ApiResponse<ApiSuccessResponse> update(final UserUpdateRequestDto userUpdateRequestDto) {
        return null;
    }

    @Override
    public ApiResponse<ApiSuccessResponse> delete(final String userId) {
        return null;
    }
}
