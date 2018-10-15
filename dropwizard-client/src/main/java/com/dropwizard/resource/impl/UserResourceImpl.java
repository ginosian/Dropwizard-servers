package com.dropwizard.resource.impl;

import com.dropwizard.client.request.UserCreationRequestDto;
import com.dropwizard.client.request.UserUpdateRequestDto;
import com.dropwizard.client.responce.ApiSuccessResponse;
import com.dropwizard.client.responce.Response;
import com.dropwizard.client.responce.dto.UserDTO;
import com.dropwizard.resource.UserResource;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Slf4j
public class UserResourceImpl implements UserResource {

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();


    @Override
    public Response<UserDTO> get(final Long userId) {
        return null;
    }

    @Override
    public Response<UserDTO> create(final UserCreationRequestDto userCreationRequestDto) {
        return null;
    }

    @Override
    public Response<UserDTO> update(final UserUpdateRequestDto userUpdateRequestDto) {
        return null;
    }

    @Override
    public Response<ApiSuccessResponse> delete(final Long userId) {
        return null;
    }
}
