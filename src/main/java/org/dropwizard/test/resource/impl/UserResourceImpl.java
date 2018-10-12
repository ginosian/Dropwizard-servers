package org.dropwizard.test.resource.impl;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.dropwizard.test.core.request.UserCreationRequestDto;
import org.dropwizard.test.core.request.UserUpdateRequestDto;
import org.dropwizard.test.core.responce.ApiErrorResponse;
import org.dropwizard.test.core.responce.ApiResponse;
import org.dropwizard.test.core.responce.ApiSuccessResponse;
import org.dropwizard.test.core.responce.GenericListResponse;
import org.dropwizard.test.core.responce.dto.UserDTO;
import org.dropwizard.test.resource.UserResource;
import org.dropwizard.test.service.UserService;
import org.dropwizard.test.service.model.UserCreationRequest;

import javax.inject.Inject;

@Slf4j
public class UserResourceImpl implements UserResource {

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private final UserService userService;

    @Inject
    public UserResourceImpl(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public ApiResponse<UserDTO> get(final String userId) {
        return null;
    }

    @Override
    public ApiResponse<GenericListResponse<UserDTO>> getALL() {
        return null;
    }

    @Override
    public ApiResponse<ApiSuccessResponse> create(final UserCreationRequestDto userCreationRequestDto) {
        try {
            userService.create(mapperFactory.getMapperFacade().map(userCreationRequestDto, UserCreationRequest.class));
            final ApiResponse<ApiSuccessResponse> apiResponse = new ApiResponse<>();
            //Add id to log message
            apiResponse.setApiResponse(new ApiSuccessResponse("TestUser successfully created"));
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
