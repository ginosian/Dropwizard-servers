package com.dropwizard.resource.impl;

import com.dropwizard.client.api.ApiClient;
import com.dropwizard.client.request.UserCreationRequestDto;
import com.dropwizard.client.request.UserUpdateRequestDto;
import com.dropwizard.client.responce.ApiSuccessResponse;
import com.dropwizard.client.responce.Response;
import com.dropwizard.client.responce.dto.UserDTO;
import com.dropwizard.resource.UserResource;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import javax.inject.Inject;

@Slf4j
public class UserResourceImpl implements UserResource {

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private final ApiClient apiClient;

    @Inject
    public UserResourceImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public Response<UserDTO> get(final Long userId) {
        return apiClient.user().get(userId);
    }

    @Override
    public Response<UserDTO> create(final UserCreationRequestDto userCreationRequestDto) {
        return apiClient.user().create(userCreationRequestDto);
    }

    @Override
    public Response<UserDTO> update(final UserUpdateRequestDto userUpdateRequestDto) {
        return apiClient.user().update(userUpdateRequestDto);
    }

    @Override
    public Response<ApiSuccessResponse> delete(final Long userId) {
        return apiClient.user().delete(userId);
    }
}
