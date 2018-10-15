package org.dropwizard.test.resource.impl;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.dropwizard.test.core.entity.User;
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
import org.dropwizard.test.service.model.UserUpdateRequest;

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
    public ApiResponse<UserDTO> get(final Long userId) {
        try {
            final User user = userService.get(userId);
            final ApiResponse<UserDTO> apiResponse = new ApiResponse<>();
            //Add id to log message
            apiResponse.setApiResponse(mapperFactory.getMapperFacade().map(user, UserDTO.class));
            return apiResponse;
        } catch (Exception e) {
            final ApiResponse<UserDTO> apiResponse = new ApiResponse<>();
            //Add id to log message
            apiResponse.setErrorResponse(new ApiErrorResponse(String.format("Failed to get user:'%s'.", userId)));
            return apiResponse;
        }
    }

    @Override
    public ApiResponse<GenericListResponse<UserDTO>> getALL() {
        return null;
    }

    @Override
    public ApiResponse<UserDTO> create(final UserCreationRequestDto userCreationRequestDto) {
        try {
            final User user = userService.create(mapperFactory.getMapperFacade().map(userCreationRequestDto, UserCreationRequest.class));
            final ApiResponse<UserDTO> apiResponse = new ApiResponse<>();
            //Add id to log message
            apiResponse.setApiResponse(mapperFactory.getMapperFacade().map(user, UserDTO.class));
            return apiResponse;
        } catch (Exception e) {
            final ApiResponse<UserDTO> apiResponse = new ApiResponse<>();
            //Add id to log message
            apiResponse.setErrorResponse(new ApiErrorResponse("Failed to create user"));
            return apiResponse;
        }
    }

    @Override
    public ApiResponse<UserDTO> update(final UserUpdateRequestDto userUpdateRequestDto) {
        try {
            final User user = userService.update(mapperFactory.getMapperFacade().map(userUpdateRequestDto, UserUpdateRequest.class));
            final ApiResponse<UserDTO> apiResponse = new ApiResponse<>();
            //Add id to log message
            apiResponse.setApiResponse(mapperFactory.getMapperFacade().map(user, UserDTO.class));
            return apiResponse;
        } catch (Exception e) {
            final ApiResponse<UserDTO> apiResponse = new ApiResponse<>();
            //Add id to log message
            apiResponse.setErrorResponse(new ApiErrorResponse(String.format("Failed to get user:'%s'.", userUpdateRequestDto.getId())));
            return apiResponse;
        }
    }

    @Override
    public ApiResponse<ApiSuccessResponse> delete(final Long userId) {
        try {
            final String successMessage = userService.delete(userId);
            final ApiResponse<ApiSuccessResponse> apiResponse = new ApiResponse<>();
            //Add id to log message
            apiResponse.setApiResponse(new ApiSuccessResponse(successMessage));
            return apiResponse;
        } catch (Exception e) {
            final ApiResponse<ApiSuccessResponse> apiResponse = new ApiResponse<>();
            //Add id to log message
            apiResponse.setErrorResponse(new ApiErrorResponse(String.format("Failed to delete user:'%s'.", userId)));
            return apiResponse;
        }
    }
}
