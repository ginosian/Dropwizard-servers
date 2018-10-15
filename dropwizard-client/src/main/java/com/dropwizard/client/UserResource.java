package com.dropwizard.client;

import com.dropwizard.client.api.AbstractApiResource;
import com.dropwizard.client.request.UserCreationRequestDto;
import com.dropwizard.client.request.UserUpdateRequestDto;
import com.dropwizard.client.responce.Response;
import com.dropwizard.client.responce.ApiSuccessResponse;
import com.dropwizard.client.responce.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

@Slf4j
public class UserResource extends AbstractApiResource {

    private ObjectMapper objectMapper;

    public UserResource(Client client, WebTarget rootTarget, ObjectMapper objectMapper) {
        super(client, rootTarget, "");
        this.objectMapper = objectMapper;
    }


    public Response<UserDTO> get(final Long id) {
        return doGet("/" +id, new GenericType<Response<UserDTO>>() {});
    }

    public Response<UserDTO> create(final UserCreationRequestDto userCreationRequestDto) {

        return doPost(StringUtils.EMPTY, userCreationRequestDto, new GenericType<Response<UserDTO>>() {});
    }

    public Response<UserDTO> update(final UserUpdateRequestDto userUpdateRequestDto) {
        return doPut(StringUtils.EMPTY, userUpdateRequestDto, new GenericType<Response<UserDTO>>() {});
    }

    public Response<ApiSuccessResponse> delete(final Long id) {
        return doDelete("/" +id, new GenericType<Response<ApiSuccessResponse>>() {});
    }
}
